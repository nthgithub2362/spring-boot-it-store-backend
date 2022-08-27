package com.nguyenthanhhau.itstore.entity.logo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logo")
public class Logo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;
	
	@Column(name = "title")
	private String title;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public Logo(long id, String name, String image, String title) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.title = title;
	}

	public Logo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
