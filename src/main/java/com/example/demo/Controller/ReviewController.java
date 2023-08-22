package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ReviewRepository;

import com.example.demo.model.Review;



@RestController
public class ReviewController {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@PostMapping("/review")
	public ResponseEntity<Object> addUser(@RequestBody Review body){
		try {
			
			Review newreview = reviewRepository.save(body);
			
			return new ResponseEntity<>(newreview,HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error ",HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
}
