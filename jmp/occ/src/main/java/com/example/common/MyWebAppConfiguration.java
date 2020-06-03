package com.example.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
public class MyWebAppConfiguration extends WebMvcConfigurationSupport {
	
	  @Override 
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	   }
			 
}
