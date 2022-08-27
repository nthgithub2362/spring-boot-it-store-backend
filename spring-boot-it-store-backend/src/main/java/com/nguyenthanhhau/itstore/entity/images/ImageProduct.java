package com.nguyenthanhhau.itstore.entity.images;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nguyenthanhhau.itstore.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "image_product")
public class ImageProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "image")
	private String image;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

	
	public ImageProduct(String image, Product product) {
		super();
		this.image = image;
	}



	public ImageProduct(long id, String image, Product product) {
		super();
		this.id = id;
		this.image = image;
		this.product = product;
	}
	public ImageProduct() {

	}

	public ImageProduct(long id) {
		super();
		this.id = id;
	}

	public ImageProduct(long id, String image) {
		super();
		this.id = id;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
//	public Product getProduct() {
//		return product;
//	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
}
	
