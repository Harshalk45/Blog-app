package com.codewithharshal.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security	.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;

//@Configuration
//public class SecurityConfiguration{
//    
//	//@Override
//	//protected void configure(HttpSecurity http) throws Exception{
////		
////		http.
////		.csrf()
////		.disable()
////		.authorizeHttpRequests()
////		.anyRequest()
////		.authenticated()
////		.and()
////		.httpBasic();
////		}
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity  http)throws Exception {
//		http
//		.csrf()
//		.disable()
//		.authorizeHttpRequests()
//        .anyRequest()
//        .authenticated();
//        
//	}
//	
//}
