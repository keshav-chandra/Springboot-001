package com.jsp.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.jsp")//specifying the package name of our rest controller
@EnableJpaRepositories(basePackages = "com.jsp.demo1.repository")//specifying the package name repository to spring boot
@EntityScan(basePackages = "com.jsp.demo1.dto")//specifying the location(package name) of our entity classes to spring boot
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		
	}

}
