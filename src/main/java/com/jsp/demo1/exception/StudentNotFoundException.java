package com.jsp.demo1.exception;

public class StudentNotFoundException extends RuntimeException {
 String message;
 public StudentNotFoundException (String msg) {
	 message=msg;
 }
@Override
public String getMessage() {
	return message;
}


 
}
