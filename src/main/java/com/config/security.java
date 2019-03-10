package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.service.UserService;

@Configuration
@EnableWebSecurity
public class security extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserService myAppUserDetailsService;	
	@Autowired
	private AppAuthenticationEntryPoint appAuthenticationEntryPoint;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").authenticated()
		.antMatchers("/registration").permitAll();

	} 
        @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
	}
}
