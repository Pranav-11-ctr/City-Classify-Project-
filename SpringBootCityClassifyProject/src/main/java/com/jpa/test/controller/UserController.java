package com.jpa.test.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.test.dto.CityClassifyDTO;
import com.jpa.test.model.CityClassify;
import com.jpa.test.repository.UserRepository;
import com.jpa.test.service.CityClassifyService;
import com.jpa.test.service.CityService;
import com.jpa.test.service.UserService;

@Controller
public class UserController {
	
	Logger logger=LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@Autowired
	CityService cityService;
	@Autowired
	CityClassifyService cityClassifyService;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	
	@GetMapping("/user/cityclassifies/add")
	public String cityClassifyAddGet(Model model)
	{
		model.addAttribute("cityClassifyDTO",new CityClassifyDTO());
		model.addAttribute("cities",cityService.getAllCity());
		return "userCityClassify";
	}
	
	@PostMapping("/user/cityclassifies/add")
	public String cityClassifyAddPost(@ModelAttribute("cityClassifyDTO")CityClassifyDTO cityClassifyDTO,
		
			@RequestParam(value = "imgName",required = false)String imgName) throws IOException
	{
		CityClassify cityClassify=new CityClassify();
		cityClassify.setId(cityClassifyDTO.getId());
		cityClassify.setContact(cityClassifyDTO.getContact());

		cityClassify.setCity(cityService.getCityById(cityClassifyDTO.getCityId()).orElse(null));
		cityClassify.setDescription(cityClassifyDTO.getDescription());
		
		cityClassifyService.addCityClassify(cityClassify);
		
		return "redirect:/user/userCityClassify";
	}

	
	
	@GetMapping("/user/cityClassifies")
	public String cityClassifies(Model model)
	{
		logger.info("Call Before getting");
		model.addAttribute("cityClassifies",cityClassifyService.getAllCityClassify());
		logger.info("Call after getting");
		return "cityclassifiesUser";
	}
	

	@GetMapping("/user/cities")
	public String cities(Model model)
	{
		logger.info("Call Before getting");
		model.addAttribute("cities",cityService.getAllCity());
		logger.info("Call after getting");
		return "citiesUser";
	}
	
	
	
	

}
