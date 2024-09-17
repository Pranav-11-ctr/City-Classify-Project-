package com.jpa.test.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.jpa.test.dto.CityClassifyDTO;

import com.jpa.test.model.City;
import com.jpa.test.model.CityClassify;
import com.jpa.test.model.CustomException;
import com.jpa.test.service.CityClassifyService;
import com.jpa.test.service.CityService;
import com.jpa.test.service.UserService;
import com.jpa.test.service.UserServiceImpl;

@Controller
public class AdminController {
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);
	public  static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/cityClassifiesImages";
	
	@Autowired
	CityService cityService;
	@Autowired
	CityClassifyService cityClassifyService;
	@Autowired
	UserService  userService;
	@Autowired
	UserServiceImpl userServiceImpl;
	
	String cities="cities";
	
	//Admin Home page
	@GetMapping("/admin")
	public String adminHome()
	{
		return "adminHome";
	}
	
	//admin can get all city
	@GetMapping("/admin/cities")
	public String getCity(Model model)
	{
		model.addAttribute(cities,cityService.getAllCity());
		return cities;
	}
	
	//Admin can add city by get
	@GetMapping("/admin/cities/add")
	public String getCityAdd(Model model)
	{
		model.addAttribute("city",new City());
		return "citiesAdd";
	}
	//Admin can add city by post
	@PostMapping("/admin/cities/add")
	public String postCityAdd(@ModelAttribute("city") City city)
	{
		cityService.addCity(city);
		return "redirect:/admin/cities";
	}
	
	//Admin can delete city by id
	@GetMapping("/admin/cities/delete/{id}")
	public String deleteCity(@PathVariable int id)
	{
		cityClassifyService.deleteByCityId(id);
		cityService.removeCityById(id);
		return "redirect:/admin/cities";
	}
	
	//Admin can update city by id
	@GetMapping("/admin/cities/update/{id}")
	public String updateCity(@PathVariable int id,Model model) throws Exception
	{
		Optional<City> city=cityService.getCityById(id);
		if(city.isPresent())
		{
			model.addAttribute("city",city.get());
			return "citiesAdd";
		}
		else
		{
			throw new CustomException("City is not available"); 
		}
	}
	
	
	
	
	//CityClassifySearch
	//Admin can  get cityclassify
	@GetMapping("/admin/cityclassifies")
	public String cityClassifies(Model model)
	{
		model.addAttribute("cityClassifies",cityClassifyService.getAllCityClassify());
		return "cityclassifies";
	}
	
	//Admin can add cityclassify by get
	@GetMapping("/admin/cityclassifies/add")
	public String cityClassifyAddGet(Model model)
	{
		model.addAttribute("cityClassifyDTO",new CityClassifyDTO());
		model.addAttribute(cities,cityService.getAllCity());
		return "cityclassifiesAdd";
	}
	
	//Admin can add by post
	@PostMapping("/admin/cityclassifies/add")
	public String cityClassifyAddPost(@ModelAttribute("cityClassifyDTO")CityClassifyDTO cityClassifyDTO,
		//	@RequestParam("cityClassifyImage")MultipartFile file,
			@RequestParam(value = "imgName",required = false)String imgName) throws IOException
	{
		CityClassify cityClassify=new CityClassify();
		cityClassify.setId(cityClassifyDTO.getId());
		cityClassify.setContact(cityClassifyDTO.getContact());
		
		cityClassify.setCity(cityService.getCityById(cityClassifyDTO.getCityId()).orElse(null));
		cityClassify.setPostName(cityClassifyDTO.getPostName());
		cityClassify.setDescription(cityClassifyDTO.getDescription());

		cityClassifyService.addCityClassify(cityClassify);
		
		return "redirect:/admin/cityclassifies";
	}
	
	//Admin can delete by cityclassify by id
	@GetMapping("/admin/cityClassify/delete/{id}")
	public String deleteCityClassify(@PathVariable long id)
	{
		cityClassifyService.removeCityClassifyById(id);
		return "redirect:/admin/cityclassifies";
	}
	
	//Admin can update by id
	@GetMapping("/admin/cityClassify/update/{id}")
	public String updateCityClassify(@PathVariable long id,Model model)
	{
		
		CityClassify cityClassify=cityClassifyService.getCityClassifyById(id).orElseThrow(()->new NullPointerException());
		CityClassifyDTO cityClassifyDTO=new CityClassifyDTO();
		cityClassifyDTO.setId(cityClassify.getId());
		cityClassifyDTO.setContact(cityClassify.getContact());
		cityClassifyDTO.setDescription(cityClassify.getDescription());
		cityClassifyDTO.setCityId(cityClassify.getCity().getId());
		model.addAttribute(cities,cityService.getAllCity());
		model.addAttribute("cityClassifyDTO",cityClassifyDTO);
		return "cityclassifiesAdd";
	}
	
	
	//Admin can get all users
	@GetMapping("/admin/users")
	public String users(Model model)
	{
		model.addAttribute("users",userServiceImpl.getAll());
		return "users";
	}
	
	//Admin can delete by id
	@GetMapping("/admin/users/delete/{id}")
	public String deleteUser(@PathVariable long id)
	{
		cityClassifyService.deleteByUserId(id);
		userServiceImpl.removeUser(id);
		return "redirect:/admin/users";
	}
	
	
	
	
	
	
	
	
	
	

}
