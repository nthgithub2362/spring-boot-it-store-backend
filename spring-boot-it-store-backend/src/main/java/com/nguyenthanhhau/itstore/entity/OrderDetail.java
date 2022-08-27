package com.nguyenthanhhau.itstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_detail_order;
	
	@Column(name = "id")
	private long id;
	
	@Column(name = "id_order")
	private String id_order;
	
	@Column(name = "quantity")
	private long quantity;

	@Column(name = "price") 
	private long price;

	

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(String id_order, long quantity, long price) {
		super();
		this.id_order = id_order;
		this.quantity = quantity;
		this.price = price;
	}

	public long getId_detail_order() {
		return id_detail_order;
	}

	public void setId_detail_order(long id_detail_order) {
		this.id_detail_order = id_detail_order;
	}

	public long getId() { 
		return id;
	} 

	public void setId(long id) {
		this.id = id;
	}

	public String getId_order() {
		return id_order;
	}

	public void setId_order(String id_order) {
		this.id_order = id_order;
	}


	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
