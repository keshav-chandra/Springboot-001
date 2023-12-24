package com.jsp.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.demo1.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{
User findByEmailAndPassword(String email,String password);
}
