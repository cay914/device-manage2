package com.codebattery.filters;


import com.codebattery.model.Response;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

@Component
public class ResponseFilter extends ZuulFilter{
	
    private static final int  FILTER_ORDER=1;
    private static final boolean  SHOULD_FILTER=true;

//    @Autowired
//    FilterUtils filterUtils;

    @Override
    public String filterType() {
        return FilterUtils.POST_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
    	RequestContext ctx = RequestContext.getCurrentContext();
    	HttpServletRequest request = ctx.getRequest();
    	
    	StringBuffer requestURL = request.getRequestURL();
    	if(requestURL!=null && 
    			( requestURL.toString().contains("swagger-ui.html") 
    					|| requestURL.toString().contains("api-docs"))) {
    		return false;	//不拦截doc请求
    	}
    	
        return SHOULD_FILTER;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponse().addHeader(FilterUtils.CORRELATION_ID, FilterUtils.getCorrelationId());
        
        InputStream stream = ctx.getResponseDataStream();
        String bodyStr;
        Response response = null;
		try {
			bodyStr = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
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
			ctx.setResponseBody(responseJson.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return null;
    }

}
