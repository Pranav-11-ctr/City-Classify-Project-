package com.jpa.test.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jpa.test.controller.dto.UserRegistrationDto;
import com.jpa.test.model.User;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
