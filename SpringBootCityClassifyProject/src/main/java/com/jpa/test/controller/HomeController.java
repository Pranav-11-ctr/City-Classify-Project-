package com.jpa.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpa.test.service.CityClassifyService;
import com.jpa.test.service.CityService;

@Controller
public class HomeController {
	
	Logger logger=LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CityService cityService;
	@Autowired
	CityClassifyService cityClassifyService;
	
	
	
	@GetMapping("/cityclassify")
	public String cityclassify(Model model)
	{
		model.addAttribute("cities",cityService.getAllCity());
		model.addAttribute("cityclassifies",cityClassifyService.getAllCityClassify());
		return "cityclassify";
	}
	
	@GetMapping("/cityclassify/city/{id}")
	public String cityclassifyByCity(Model model,@PathVariable int id )
	{
		model.addAttribute("cities",cityService.getAllCity());
		model.addAttribute("cityclassifies",cityClassifyService.getAllCityClassifyByCityId(id));
		return "cityclassify";
	}
	

}
