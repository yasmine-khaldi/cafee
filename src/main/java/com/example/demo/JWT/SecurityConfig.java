package com.example.demo.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;



@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig  {

	@Autowired
	CustomerUsersDetailsService customerUsersDetailsService;

	@Autowired
	JwtFilter jwtFilter;

	@Autowired
	AuthenticationProvider authenticationProvider ;
	
	@Bean // Default Behaviour of HttpSecurityObj will not have any authorization logic
	public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
		

		http
			.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/user/login","/user/signup","/user/forgotPassword")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authenticationProvider(authenticationProvider)
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
			
		return http.build();
		
		
	}
	
}



	























