package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class appconfig extends WebMvcConfigurerAdapter{
	 
		@Override
		public void addCorsMappings(CorsRegistry registry) {
	 
			registry.addMapping("/**")
					.allowedOrigins("http://localhost:4200")
					.allowedMethods("POST", "GET", "PUT", "DELETE")
					.allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
	                        "Access-Control-Request-Headers","Access-Control-Allow-Origin")
					.exposedHeaders("header-1", "header-2")
					.allowCredentials(false)
					.maxAge(6000);
	 
		}
}

