package com.nguyenthanhhau.itstore.entity;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nguyenthanhhau.itstore.entity.images.ImageProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "paramater")
	private String paramater;

	@Column(name = "image")
	private String image;

	@Column(name = "brand")
	private String brand;

	@Column(name = "price")
	protected double price;

	@Column(name = "price_net")
	protected double price_net;

	@Column(name = "available")
	protected int available;

	@Column(name = "sold")
	protected int sold;

	@Column(name = "deal_timer")
	protected Date deal_timer;

	@Column(name = "cateid")
	protected int cateid;

	@Column(name = "event")
	protected String event;

	@Column(name = "gift")
	protected long gift;

	@Column(name = "promotion")
	protected String promotion;

//	@ManyToOne
//    @JoinColumn(name = "category_id")
//	private Category category;

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "product_re")
	private Set<ProductRelated> productrelate = new HashSet<>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id) {
		super();
		this.id = id;
	}
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "product_id")
	private Review review;
	// images-detail-product
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "product_id",nullable = true)
	private Set<ImageProduct> productimage = new HashSet<>();

	public Product(long id, String name, String title, String description, String paramater, String image, String brand,
			double price, double price_net, int available, int sold, Date deal_timer, int cateid, String event,
			long gift, String promotion,Set<ImageProduct> productimage, Set<ProductRelated> productrelate,
			Review review) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.description = description;
		this.paramater = paramater;
		this.image = image;
		this.brand = brand;
		this.price = price;
		this.price_net = price_net;
		this.available = available;
		this.sold = sold;
		this.deal_timer = deal_timer;
		this.cateid = cateid;
		this.event = event;
		this.gift = gift;
		this.promotion = promotion;
		this.productimage = productimage;
		this.productrelate = productrelate;
		this.review = review;
	}

	

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Product(long id, String name, String title, String description, String paramater, String image, String brand,
			double price, double price_net, int available, int sold, Date deal_timer, int cateid, String event,
			long gift, String promotion) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.description = description;
		this.paramater = paramater;
		this.image = image;
		this.brand = brand;
		this.price = price;
		this.price_net = price_net;
		this.available = available;
		this.sold = sold;
		this.deal_timer = deal_timer;
		this.cateid = cateid;
		this.event = event;
		this.gift = gift;
		this.promotion = promotion;

	}

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

	public String getParamater() {
		return paramater;
	}

	public void setParamater(String paramater) {
		this.paramater = paramater;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice_net() {
		return price_net;
	}

	public void setPrice_net(double price_net) {
		this.price_net = price_net;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public Date getDeal_timer() {
		return deal_timer;
	}

	public void setDeal_timer(Date deal_timer) {
		this.deal_timer = deal_timer;
	}

	public int getCateid() {
		return cateid;
	}

	public void setCateid(int cateid) {
		this.cateid = cateid;
	}

	public long getCategory_id() {
		return id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public long getGift() {
		return gift;
	}

	public void setGift(long gift) {
		this.gift = gift;
	}

	public String getPromotion() {
		return promotion;
	}

	public Set<ProductRelated> getProductrelate() {
		return productrelate;
	}

	public void setProductrelate(Set<ProductRelated> productrelate) {
		this.productrelate = productrelate;
	}

	public Set<ImageProduct> getProductimage() {
		return productimage;
	}

	public void setProductimage(Set<ImageProduct> productimage) {
		this.productimage = productimage;
	}

}
