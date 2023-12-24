package com.jsp.demo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.demo1.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	//if we want to find the data for the specific student then we have to go by findby methods
List<Student> findByName(String name);
List<Student> findByAgeGreaterThan(int age);
List<Student> findByAgeLessThan(int age);
Student findByMobilenumber(Long mobilenumber);
List<Student>findByAgeBetween(int age1,int age2);
}
