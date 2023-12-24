package com.jsp.demo1.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.demo1.dto.Student;
import com.jsp.demo1.exception.StudentNotFoundException;
import com.jsp.demo1.helper.ResponseStructure;
import com.jsp.demo1.repository.StudentRepository;

@RestController  //@controller + @responsebody
public class HomeController {
	@Autowired 
	StudentRepository repository;
	
@PostMapping("/hi")
public String m1() {
	return "hello world";
}
@GetMapping("/hi")
public String m2() {
	return "good morning";
}
@PostMapping("/save")
public String saveStudent(@RequestBody Student student) {
	repository.save(student);
	return "data saved";
}
@GetMapping("/fetchstudent")
public ResponseStructure<Student> fetchStudent(@RequestParam("id")int id) {
	Optional<Student>option=repository.findById(id);
	if(option.isPresent()) {
	Student student=option.get();
	//return student;
	ResponseStructure<Student> response=new ResponseStructure<Student>() ;
	response.setStatuscode(HttpStatus.FOUND.value());
	response.setMessage("data  found");
	response.setSetdata(student);
	return response;
	}
	else {
		throw new StudentNotFoundException("student not found");
	}
	
}
@GetMapping("/fetchstudentbyname")
public ResponseStructure<Student> fetchStudentByName(@RequestParam("name")String name){
	Student student = null;
	//return repository.findByName(name);
	ResponseStructure<Student>response=new ResponseStructure<Student>();
	response.setStatuscode(HttpStatus.FOUND.value());
	response.setMessage("data found");
	
	response.setSetdata(student);
	return response;
}
@PostMapping("/fetchstudentbyageless")
public List<Student>fetchStudentByAgeLess(@RequestParam("age")int age){
	return repository.findByAgeLessThan(age);
}
@GetMapping("/fetchstudentbetween")
public List<Student>fetchStudentByAgeBetween(@RequestParam("start")int age1,@RequestParam("end")int age2){
	return repository.findByAgeBetween(age1,age2);
}
@DeleteMapping("/deletestudent")
public ResponseStructure<Student>deleteStudent(@RequestParam("id") int id){
	repository.deleteById(id);
	ResponseStructure<Student>response=new ResponseStructure<Student>();
	response.setStatuscode(HttpStatus.OK.value());
	response.setMessage("data deleted");
	return response;
}
@PutMapping("/update")
public ResponseStructure<Student>updateStudent(@RequestBody Student s){
	repository.save(s);
	ResponseStructure<Student>response=new ResponseStructure<Student>();
	response.setStatuscode(HttpStatus.ACCEPTED.value());
	response.setMessage("data updated");
	response.setSetdata(s);
	return response;
}
@PatchMapping("/patchreq")
public ResponseStructure<Student>patchStudent(@RequestParam("name")String name,@RequestParam("id")int id){
	Optional<Student>option=repository.findById(id);
	Student student=option.get();
	student.setName(name);
	
	repository.save(student);
	ResponseStructure<Student>response=new ResponseStructure<Student>();
	response.setStatuscode(HttpStatus.ACCEPTED.value());
	response.setMessage("data updated");
	response.setSetdata(student);
	return response;
}
}
