package com.nguyenthanhhau.itstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slider")
public class Slider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	

	@Column(name = "name")
	private String name;

	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image")
	private String image;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Slider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Slider(long id, String name, String title, String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.description = description;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Slider [id=" + id + ", name=" + name + ", title=" + title + ", description=" + description + ", image="
				+ image + "]";
	}
	
}
