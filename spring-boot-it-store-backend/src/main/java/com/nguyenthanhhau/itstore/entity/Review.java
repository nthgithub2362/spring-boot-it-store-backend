package com.nguyenthanhhau.itstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title_review")
	private String title_review;
	
	@Column(name = "image_review")
	private String image_review;
	
	@Column(name = "description_review")
	private String description_review;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(long id, String title_review, String image_review, String description_review) {
		super();
		this.id = id;
		this.title_review = title_review;
		this.image_review = image_review;
		this.description_review = description_review;
	}

	public Review(long id, String title_review, String image_review, String description_review, Product product) {
		super();
		this.id = id;
		this.title_review = title_review;
		this.image_review = image_review;
		this.description_review = description_review;
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle_review() {
		return title_review;
	}

	public void setTitle_review(String title_review) {
		this.title_review = title_review;
	}

	public String getImage_review() {
		return image_review;
	}

	public void setImage_review(String image_review) {
		this.image_review = image_review;
	}

	public String getDescription_review() {
		return description_review;
	}

	public void setDescription_review(String description_review) {
		this.description_review = description_review;
	}

//	public Product getProduct() {
//		return product;
//	}

	public void setProduct(Product product) {
		this.product = product;
	}

	


	
	
}
