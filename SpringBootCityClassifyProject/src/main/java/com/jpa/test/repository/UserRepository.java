package com.jpa.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.test.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}















