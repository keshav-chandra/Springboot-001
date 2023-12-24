package com.jsp.demo1.helper;

import com.jsp.demo1.dto.Student;
import com.jsp.demo1.exception.StudentNotFoundException;

public class ResponseStructure<T> {
  private int statuscode;
  private String message;
  private T setdata;
public int getStatuscode() {
	return statuscode;
}
public void setStatuscode(int statuscode) {
	this.statuscode = statuscode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public T getSetdata() {
	return setdata;
}
public void setSetdata(T setdata) {
	this.setdata = setdata;
}



  
}
