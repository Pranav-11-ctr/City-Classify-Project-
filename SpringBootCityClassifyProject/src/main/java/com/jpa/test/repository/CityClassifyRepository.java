package com.jpa.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.model.CityClassify;

public interface CityClassifyRepository extends JpaRepository<CityClassify, Long> {
	List<CityClassify> findAllByCity_Id(int id);
	List<CityClassify> findAllByuser_id(long id);
	public void deleteByuser_id(long id);
	public void deleteBycity_id(int id);
	

}
