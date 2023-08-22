package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@RequestBody User body){
		try {
			
			User user = userRepository.save(body);
			
			return new ResponseEntity<>(user,HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error ",HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
}
