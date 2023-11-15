package com.example.demo.serviceImpls;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		return null;
		// TODO Auto-generated method stub
		
		
	}
	private boolean validateSignUpMap(Map<String,String> requestMap) {
		if( requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email") && requestMap.containsKey("password")) {
			return true ;
		}
		return false;
	}

}
