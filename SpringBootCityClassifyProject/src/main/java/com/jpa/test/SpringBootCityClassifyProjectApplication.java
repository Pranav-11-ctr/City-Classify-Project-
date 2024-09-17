package com.jpa.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCityClassifyProjectApplication {

	public static final Logger logger=LoggerFactory.getLogger(SpringBootCityClassifyProjectApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootCityClassifyProjectApplication.class, args);
	}

}
