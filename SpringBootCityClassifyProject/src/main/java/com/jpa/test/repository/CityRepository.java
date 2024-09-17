package com.jpa.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
