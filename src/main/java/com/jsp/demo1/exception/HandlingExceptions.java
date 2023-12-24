package com.jsp.demo1.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.demo1.dto.Student;
import com.jsp.demo1.helper.ResponseStructure;

@RestControllerAdvice
public class HandlingExceptions {
	@ExceptionHandler(value=StudentNotFoundException.class)
public ResponseStructure<StudentNotFoundException> m1(StudentNotFoundException s){
		ResponseStructure<StudentNotFoundException> response=new ResponseStructure<StudentNotFoundException>();
		response.setStatuscode(HttpStatus.NOT_FOUND.value());
		response.setMessage(s.getMessage());
		response.setSetdata(s);
		return response;
	}
}
