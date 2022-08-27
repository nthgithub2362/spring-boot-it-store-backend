package com.nguyenthanhhau.itstore.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "category")
public class Category {
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
		
		
		@Column(name = "name")
		private String name;
		
		
		
		@Column(name = "id_parent")
		private long id_parent;
		
	
		
		


//		@OneToMany(mappedBy = "category")
//		
//		private List<Product> product = new ArrayList<>();
//
//		public List<Product> getProduct() {
//			return product;
//		}
//
//		public void setProduce(List<Product> product) {
//			this.product = product;
//		}
		
		@OneToMany(mappedBy = "category")
		
		private List<New> news = new ArrayList<>();

		public List<New> getNew() {
			return news;
		}

		public void setNew(List<New> news) {
			this.news = news;
		}
		
		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Category(long id, String name, long id_parent) {
			super();
			this.id = id;
			this.name = name;
			
			this.id_parent = id_parent;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		

		public long getId_parent() {
			return id_parent;
		}

		public void setId_parent(long id_parent) {
			this.id_parent = id_parent;
		}

	
		
	    
	}
