package com.jpa.test.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.model.CityClassify;
import com.jpa.test.repository.CityClassifyRepository;

@Service
public class CityClassifyService {

	@Autowired
	CityClassifyRepository cityClassifyRepository;

	public List<CityClassify> getAllCityClassify() {
		return cityClassifyRepository.findAll();
	}
	public void removeCityClassifyById(long id )
	{
		cityClassifyRepository.deleteById(id);
	}
	
	public Optional<CityClassify> getCityClassifyById(long id)
	{
		return cityClassifyRepository.findById(id);
	}
	public List<CityClassify> getAllCityClassifyByCityId(int id)
	{
		return cityClassifyRepository.findAllByCity_Id(id);
	}
	public void addCityClassify(CityClassify cityClassify)
	{
		cityClassifyRepository.save(cityClassify);
	}
	
	public List<CityClassify> getCityClassifyByuser_id(long id)
	{
		return cityClassifyRepository.findAllByuser_id(id);
	}
	
	@Transactional
	public void deleteByUserId(long id)
	{
		cityClassifyRepository.deleteByuser_id(id);
	}
	@Transactional
	public void deleteByCityId(int id)
	{
		cityClassifyRepository.deleteBycity_id(id);
	}

}
