package com.jpa.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.test.model.CityClassify;
import com.jpa.test.repository.CityClassifyRepository;

@SpringBootTest
class CityClassifyRepositoryTest {

	@Autowired
	private CityClassifyRepository cRepo;
	
	
	@Test
	  void  getAllclassifybyidTest() {
		List<CityClassify> list=cRepo.findAllByCity_Id(3);
		assertThat(list).size();
		
	}
	@Test
	void getAllclassifybyUseridTest() {
		List<CityClassify> list=cRepo.findAllByuser_id(6);
		assertThat(list).size();
	}

}
