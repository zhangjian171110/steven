package com.qmdl.web.api.server.register;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;



/**
 * {注册类}
 *  
 *  @author Steven Zhang
 *  @created 2016年7月11日
 *  @lastModified       
 *  @history           
 */
public class RestfulApplicationAPI extends ResourceConfig{
	
	public RestfulApplicationAPI(){
		//注册JSON转换器  
	    register(JacksonJsonProvider.class); 
        //注册拦截器(中小企业不做验证)
        //register(RequestFilter.class);
	}

}




