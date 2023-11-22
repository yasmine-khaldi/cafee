package com.example.demo.JWT;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.controllers.*;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class CustomerUsersDetailsService  {

	@Autowired
	UserController userDao;
	private  com.example.demo.models.User userDetails;
	
	
	

	@Bean 
	public UserDetailsService UserDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				System.out.println("Inside loadUserByUsername {"+username+"}");

				userDetails = userDao.findByEmailId(username);
				if (!Objects.isNull(userDetails))
					return new User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());
				else
					throw new UsernameNotFoundException("User Not Found.");}

		};
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(UserDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public com.example.demo.models.User getUserDetail() {

		com.example.demo.models.User user = userDetails;
		user.setPassword(null);
		return userDetails;

	}

	


	

}
