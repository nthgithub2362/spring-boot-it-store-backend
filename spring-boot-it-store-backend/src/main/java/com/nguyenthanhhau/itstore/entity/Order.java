package com.nguyenthanhhau.itstore.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "info_order")
@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "fullname")
	private String fullname;
	@Column(name = "phone")
	private String phone;
	@Column(name = "address")
	private String address;
	@Column(name = "id_order")
	private String id_order;
	@Column(name = "user_id")
	private long user_id;
	@Column(name = "status")
	private boolean status;
	@Column(name = "date")
	
	private String date;
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(String fullname, String phone, String address, String id_order, long user_id, boolean status,
			String date) {
		super();
	
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.id_order = id_order;
		this.user_id = user_id;
		this.status = status;
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId_order() {
		return id_order;
	}
	public void setId_order(String id_order) {
		this.id_order = id_order;
	} 
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
