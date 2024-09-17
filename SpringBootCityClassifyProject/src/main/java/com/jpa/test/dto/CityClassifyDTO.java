package com.jpa.test.dto;

import lombok.Data;

@Data
public class CityClassifyDTO
{
	
	private Long id;
	private int cityId;
	private String contact;
	private String postName;
	private String description;
	
	
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	public CityClassifyDTO() {
		super();
		
	}
	public CityClassifyDTO(Long id, int cityId, String contact, String postName, String description) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.contact = contact;
		this.postName = postName;
		this.description = description;
	}
	
	
	
	
	

}

