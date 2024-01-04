package com.example.demo.restImpls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.CafeConstants;
import com.example.demo.rest.UserRest;
import com.example.demo.service.UserService;
import com.example.demo.serviceImpls.UserServiceImpl;
import com.example.demo.utils.CafeUtils;
@Controller
@RequestMapping(path = "/user")
public class UserRestImpl<UserWrapper> implements UserRest{
	
    
	UserService userService;
	
	//Sign UP
	@Override
	@PostMapping(path="/signup")
	public ResponseEntity<String> signUp(@RequestBody(required =true) Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			return userService.signUp(requestMap);
		}catch(Exception e) {e.printStackTrace();}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG_1, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//LOGIN
	@Override
	@PostMapping(path = "/login")
	public ResponseEntity<String> login(Map<String, String> requestMap) {

		try {
			return userService.login(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	//
	@Override
	@GetMapping(path = "/get")
	public ResponseEntity<List<com.example.demo.wrapper.UserWrapper>> getAllUser() {
		try {
			return userService.getAllUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<List<com.example.demo.wrapper.UserWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	@PostMapping(path = "/update")
	public ResponseEntity<String> update(Map<String, String> requestMap) {
		try {
			return userService.update(requestMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	@GetMapping(path = "/checkToken")
	public ResponseEntity<String> checkToken() {

		try {
			return userService.checkToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	@PostMapping(path = "/changePassword")
	public ResponseEntity<String> changePassword(Map<String, String> requestMap) {

		try {
			return userService.changePassword(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	@PostMapping(path = "/forgotPassword")
	public ResponseEntity<String> forgotPassword(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			return userService.forgotPassword(requestMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
