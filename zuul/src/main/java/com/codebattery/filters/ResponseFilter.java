package com.codebattery.filters;


import com.codebattery.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		try {
			ObjectMapper mapper = new ObjectMapper();
			bodyStr = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
            /*
             *   使用#占位符，body的json字符串直接替换#
             *
             */
			Response response = new Response("200", "", "#");
            String responseStr = mapper.writeValueAsString(response);
			ctx.setResponseBody(responseStr.replaceAll("#", bodyStr));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return null;
    }

}
