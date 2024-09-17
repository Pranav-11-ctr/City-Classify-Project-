package com.jpa.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.test.model.CityClassify;
import com.jpa.test.repository.CityClassifyRepository;
@SpringBootTest
class CityClassifyServiceTest {

	@Autowired
	private CityClassifyRepository cRepo;
	@Test
	void getCityClassifyById(){
		Optional<CityClassify> cty=cRepo.findById(1L);
		Assert.assertNotNull(cty);
		
	}
	
	@Test
	  void getAllCityClassifyTest() {
		List<CityClassify> list=cRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	
	}

}