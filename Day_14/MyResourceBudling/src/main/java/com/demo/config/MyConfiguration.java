package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MyConfiguration {
	
	@Bean
    public ResourceBundleMessageSource getObject() {
		System.out.println("in getobject method");
    	ResourceBundleMessageSource rs=new ResourceBundleMessageSource();
    	rs.setBasename("messages");
    	return rs;
    	
    }
}
