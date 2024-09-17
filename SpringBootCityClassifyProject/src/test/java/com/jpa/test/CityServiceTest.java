package com.jpa.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.test.model.City;
import com.jpa.test.repository.CityRepository;
import com.jpa.test.service.CityService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CityServiceTest {
	@Autowired
	private CityService service;
	@MockBean
	private CityRepository repository;
	@Autowired
	private CityRepository cRepo;

	@Test
	void removeByIdtest() {
		int id = 5;
		City city = new City(5, "asn", "mall", "dav");
		repository.save(city);
		repository.deleteById(5);
		Assert.assertNotNull(city);
	}

	@Test
	void getCityByid() {
		Optional<City> city = cRepo.findById(1);
		Assert.assertNotNull(city);

	}

}