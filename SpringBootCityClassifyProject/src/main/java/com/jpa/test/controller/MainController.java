package com.jpa.test.controller;

import java.io.IOException;
import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.test.dto.CityClassifyDTO;
import com.jpa.test.model.CityClassify;
import com.jpa.test.model.User;
import com.jpa.test.service.CityClassifyService;
import com.jpa.test.service.CityService;
import com.jpa.test.service.UserServiceImpl;

@Controller
public class MainController {
	
	Logger logger=LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	CityClassifyService cityClassifyService;
	@Autowired
	CityService cityService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home(Authentication authentication, Principal principal,Model model) {
		
		User user=userServiceImpl.getByEmail(authentication.getName());
		
		model.addAttribute("cityClassifies",cityClassifyService.getCityClassifyByuser_id(user.getId()));
		 logger.info(authentication.getName());
	        logger.info("-----------------");
	        logger.info(principal.getName());
		
		return "userCityClassify";
	}
	
	@GetMapping("/cityclassifiesAddUser/add")
	public String cityClassifyAddGet(Model model)
	{
		model.addAttribute("cityClassifyDTO",new CityClassifyDTO());
		model.addAttribute("cities",cityService.getAllCity());
		return "cityclassifiesAddUser";
	}
	
	@PostMapping("/cityclassifiesAddUser/add")
	public String cityClassifyAddPost(Authentication authentication,@ModelAttribute("cityClassifyDTO")CityClassifyDTO cityClassifyDTO,
		//	@RequestParam("cityClassifyImage")MultipartFile file,
			@RequestParam(value = "imgName",required = false)String imgName) throws IOException
	{
		logger.info("I am in user Contoller");
		User user=userServiceImpl.getByEmail(authentication.getName());
		
		if(user==null)
		{
			return "exception";
		}
		else
		{
		logger.info(String.format("This is 2nd method  %d", user.getId()));
		CityClassify cityClassify=new CityClassify();
		cityClassify.setId(cityClassifyDTO.getId());
		cityClassify.setContact(cityClassifyDTO.getContact());
		cityClassify.setUser(userServiceImpl.getByEmail(authentication.getName()));
		
		cityClassify.setCity(cityService.getCityById(cityClassifyDTO.getCityId()).orElse(null));
		cityClassify.setPostName(cityClassifyDTO.getPostName());
		cityClassify.setDescription(cityClassifyDTO.getDescription());
		

		cityClassifyService.addCityClassify(cityClassify);
		
		
		return "redirect:/";
		}
	}
	
	@GetMapping("/cityClassify/delete/{id}")
	public String deleteCityClassify(@PathVariable long id)
	{
		cityClassifyService.removeCityClassifyById(id);
		return "redirect:/";
	}
	
	@GetMapping("/cityClassify/update/{id}")
	public String updateCityClassify(@PathVariable long id,Model model)
	{
		
		
		CityClassify cityClassify=cityClassifyService.getCityClassifyById(id).orElseThrow(()->new NullPointerException());
		CityClassifyDTO cityClassifyDTO=new CityClassifyDTO();
		cityClassifyDTO.setId(cityClassify.getId());
		cityClassifyDTO.setContact(cityClassify.getContact());
		cityClassifyDTO.setDescription(cityClassify.getDescription());
		cityClassifyDTO.setCityId(cityClassify.getCity().getId());
		model.addAttribute("cities",cityService.getAllCity());
		model.addAttribute("cityClassifyDTO",cityClassifyDTO);
		return "cityclassifiesAddUser";
	}
	
}
