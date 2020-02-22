package com.codebattery.filter;

import com.codebattery.domain.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.primitives.Bytes;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBuffer;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.netty.Connection;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.CLIENT_RESPONSE_CONN_ATTR;

/**
 * 结果封装成固定200格式
 *
 * @author: Eric
 */
@Component
public class ApiResponseFilter implements GatewayFilterFactory<ApiResponseFilter.Config> {

    @Autowired
    ObjectMapper objectMapper;

    private byte [] converToJson(String str){

        byte [] jsonResponse = null;

        String bodyStr;
        Response response = null;

        bodyStr = str;
        if(bodyStr==null || bodyStr.isEmpty()){
            response = new Response("200", "", "");
        } else {
            Object json = new JSONTokener(bodyStr).nextValue();
            if(json instanceof JSONObject){
                JSONObject jsonObject = (JSONObject)json;
                response = new Response("200", "", jsonObject);
            }else if (json instanceof JSONArray){
                JSONArray jsonArray = (JSONArray)json;
                response = new Response("200", "", jsonArray);
            } else {
                response = new Response("200", "", bodyStr);
            }
        }

        JSONObject responseJson = JSONObject.fromObject(response);
        jsonResponse = responseJson.toString().getBytes();

        return jsonResponse;
    }

    private void cleanup(ServerWebExchange exchange) {
        Connection connection = exchange.getAttribute(CLIENT_RESPONSE_CONN_ATTR);
        if (connection != null) {
            connection.dispose();
        }
    }

    @Override
    public GatewayFilter apply(Config config) {

        return ((exchange, chain) -> {
            return chain.filter(exchange)
                    .doOnError(throwable -> cleanup(exchange))
                    .then(Mono.defer(() -> {
                Connection connection = exchange.getAttribute(CLIENT_RESPONSE_CONN_ATTR);
                if (connection == null) {
                    return Mono.empty();
                }
                ServerHttpResponse response = exchange.getResponse();
                NettyDataBufferFactory factory = (NettyDataBufferFactory) response.bufferFactory();
                Mono<DataBuffer> body =
                        connection
                                .inbound()
                                .receive()
                                .retain()
                                .map(factory::wrap)
                                .collectList()
                                .map(byteBufs -> {

                                    List<Byte> list = new ArrayList<>();

                                    byte [] bytes = new byte[0];

                                    for( NettyDataBuffer buf : byteBufs) {
                                        byte[] content = new byte[buf.readableByteCount()];
                                        buf.read(content);
                                        DataBufferUtils.release(buf);
                                        bytes= Bytes.concat(bytes, content);
                                    }

                                    DataBuffer dataBufferResp = factory.allocateBuffer();
                                    try {
                                        byte[] bodys  = converToJson(new String(bytes, "utf-8"));
                                        dataBufferResp.write(bodys);
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                    return dataBufferResp;
                                })
                                .doOnCancel(() -> cleanup(exchange));

                return response.writeWith(body);
            }));
        });
    }

    @Override
    public Config newConfig() {
        return new Config("ApiResponseFilter");
    }

    public static class Config {

        public Config(String name){
            this.name = name;
        }
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}