package com.jpa.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.test.model.User;
import com.jpa.test.repository.UserRepository;
@SpringBootTest
class UserServiceImplTest {
   @Autowired
	private UserRepository uRepo;
	@Test
	  void  getAllUserTest() {
		List<User> list=uRepo.findAll();
		assertThat(list).size().isGreaterThan(0);

}
}