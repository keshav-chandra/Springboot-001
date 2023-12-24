package com.jsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.demo1.dto.User;
import com.jsp.demo1.exception.UserNotFoundException;
import com.jsp.demo1.helper.Login;
import com.jsp.demo1.helper.ResponseStructure;
import com.jsp.demo1.repository.UserRepository;

@RestController
public class UserController {
@Autowired
UserRepository repository;

@PostMapping("/saveuser")
public ResponseStructure<User>saveUser(@RequestBody User user){
	repository.save(user);
	ResponseStructure<User>response=new ResponseStructure<User>();
	response.setStatuscode(HttpStatus.CREATED.value());
	response.setMessage("data saved sucessfully");
	response.setSetdata(user);
	return response;
}
@GetMapping("/loginvalidation")
public ResponseStructure<User> loginUser(@RequestBody Login l){
	User user=repository.findByEmailAndPassword(l.getEmail(),l.getPassword());
	if(user!=null) {
		ResponseStructure<User>response=new ResponseStructure<User>();
		response.setStatuscode(HttpStatus.FOUND.value());
		response.setMessage("data found");
		response.setSetdata(user);
		return response;
	}
	else {
		throw new UserNotFoundException("user not found");
	}
}
}
