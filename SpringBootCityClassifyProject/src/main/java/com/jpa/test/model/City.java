package com.jpa.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="city_id")
	private Integer id;
	private String name;
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getInstituteDetail() {
		return instituteDetail;
	}
	public void setInstituteDetail(String instituteDetail) {
		this.instituteDetail = instituteDetail;
	}
	private String institute;
	private String instituteDetail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public City(Integer id, String name, String institute, String instituteDetail) {
		super();
		this.id = id;
		this.name = name;
		this.institute = institute;
		this.instituteDetail = instituteDetail;
	}
	public City() {
		
	}
	

}
