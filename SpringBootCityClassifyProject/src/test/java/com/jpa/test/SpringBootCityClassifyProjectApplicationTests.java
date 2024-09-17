package com.jpa.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.test.model.City;
import com.jpa.test.model.CityClassify;
import com.jpa.test.model.User;
import com.jpa.test.repository.CityClassifyRepository;
import com.jpa.test.repository.CityRepository;
import com.jpa.test.repository.UserRepository;
import com.jpa.test.service.CityClassifyService;
import com.jpa.test.service.CityService;


import org.springframework.boot.test.mock.mockito.MockBean;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootCityClassifyProjectApplicationTests {
	
	@Autowired
	private CityService service;
	 @Autowired
	 CityClassifyRepository cRepo;
	 @Autowired
	 UserRepository uRepo;
	
	
	@MockBean
	private CityRepository repository;
	



	


	//test for allcity
	@Test
	  void getAllCityTest() {
	
		
		 when(repository.findAll()).thenReturn(Stream.of(new City(3,"asn","mall","dav")).collect(Collectors.toList()));
		 assertEquals("Asansol",service.getAllCity().size());
		 
	} 
	
	

	

	private void assertEquals(String string, int size) {
		
		
	}
}