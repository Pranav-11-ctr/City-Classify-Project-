package com.jpa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.test.model.User;
import com.jpa.test.repository.UserRepository;
@SpringBootTest
class UserRepositoryTest {
	
	
	@Autowired
	 UserRepository uRepo;
	
	
	//TO TEST FOR USER EXIST
		@Test
		 void findByEmail_ifexists()
		{
			User user=uRepo.findByEmail("murari@gmail.com");
			Assert.assertNotNull(user);
			}
		
		@Test
		void findByEmail_ifNotExists()
		{
			User user=uRepo.findByEmail("");
			Assert.assertNull(user);
		}
		

	

}