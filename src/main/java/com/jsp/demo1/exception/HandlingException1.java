package com.jsp.demo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.demo1.helper.ResponseStructure;

@RestControllerAdvice
public class HandlingException1 {
   @ExceptionHandler(value=UserNotFoundException.class)
   public ResponseStructure<UserNotFoundException> m1(UserNotFoundException l){
		ResponseStructure<UserNotFoundException> response=new ResponseStructure<UserNotFoundException>();
		response.setStatuscode(HttpStatus.NOT_FOUND.value());
		response.setMessage(l.getMessage());
		response.setSetdata(l);
		return response;
	}
}
