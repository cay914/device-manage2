package com.codebattery.filter;

import com.codebattery.domain.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.netty.Connection;

import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

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

    @Override
    public GatewayFilter apply(Config config) {


        return ((exchange, chain) -> {
                return chain.filter(exchange).then(Mono.defer(() -> {
                    Connection connection = exchange.getAttribute(CLIENT_RESPONSE_CONN_ATTR);
                    if (connection == null) {
                        return Mono.empty();
                    }
                    ServerHttpResponse response = exchange.getResponse();
                    NettyDataBufferFactory factory = (NettyDataBufferFactory) response.bufferFactory();
                    Mono<DataBuffer> body =
                    connection.inbound().receive()
                            .retain()
                            .map(factory::wrap)
                            .map(dataBuffer -> {
                                byte[] content = new byte[dataBuffer.readableByteCount()];
                                dataBuffer.read(content);
                                DataBufferUtils.release(dataBuffer);
                                String str = null;
                                try {
                                    str = new String(content, "UTF-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                return str;
                            }).collect(Collectors.joining(""))
                            .map(str -> {
                                DataBuffer dataBufferResp = factory.allocateBuffer();
                                byte[] bytes = converToJson(str);
                                dataBufferResp.write(bytes);
                                return dataBufferResp;
                            });

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