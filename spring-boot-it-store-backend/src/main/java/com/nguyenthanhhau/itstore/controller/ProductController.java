package com.nguyenthanhhau.itstore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.exception.ResourceNotFoundException;
import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.entity.ProductRelated;
import com.nguyenthanhhau.itstore.entity.Review;
import com.nguyenthanhhau.itstore.repository.ProductRelatedRepository;
import com.nguyenthanhhau.itstore.repository.ProductRepository;
import com.nguyenthanhhau.itstore.repository.ReviewRepository;
import com.nguyenthanhhau.itstore.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductRelatedRepository productRelatedRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ProductService productService;

	// get all
	@GetMapping("/products")
	Page<Product> getAllProduct(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
		return productRepository.findAll(PageRequest.of(page.orElse(1), 12, Sort.Direction.ASC, sortBy.orElse("id")));
	}

	@GetMapping("/products/phone")
	public List<Product> getAllProductsPhone() {
		return productRepository.listPhone();
	}

	@GetMapping("/products/lap")
	public List<Product> getAllProductsLap() {
		return productRepository.listLap();
	}

	@GetMapping("/products/watch")
	public List<Product> getAllProductsWatc() {
		return productRepository.listWatc();
	}

	@GetMapping("/products/detail-product/{id}")
	public List<Product> getAllProductCategory(@PathVariable(value = "id") Long id) {
		return productRepository.listProductRelated(id);
	}

	@GetMapping("/products/sale")
	public List<Product> getSale() {
		return productRepository.listSale();
	}

	@GetMapping("/products/accessories")
	public List<Product> geListAc() {
		return productRepository.listAccessories();
	}

	// create product rest api
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {

		return productRepository.save(product);
	}

	// get product by id rest api
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product not exist with id :" + id));
		return ResponseEntity.ok(product);
	}

	@GetMapping("/products/reviews/{id}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
		Review review = reviewRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("review not exist with id :" + id));
		return ResponseEntity.ok(review);
	}

	// update product rest api

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product not exist with id :" + id));

		product.setName(productDetails.getName());
		product.setTitle(productDetails.getTitle());
		product.setDescription(productDetails.getDescription());
		product.setImage(productDetails.getImage());
		product.setBrand(productDetails.getBrand());
		product.setPrice(productDetails.getPrice());
		product.setPrice_net(productDetails.getPrice_net());
		product.setAvailable(productDetails.getAvailable());
		product.setSold(productDetails.getSold());
		product.setDeal_timer(productDetails.getDeal_timer());

		Product updatedproduct = productRepository.save(product);
		return ResponseEntity.ok(updatedproduct);
	}

	// delete product rest api
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteproduct(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product not exist with id :" + id));

		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	// search
	@RequestMapping("/search")
	public List<Product> viewHomePage(@Param("name") String name) {
		List<Product> listProducts = productService.listAll(name);
		return listProducts;
	}

	@GetMapping("/all-product")
	public List<Product> getAllProductNoPa() {

		return productRepository.findAll();

	}

	// list of new//
	@GetMapping("/list-of-new")
	public List<Product> getlistOfNew() {

		return productRepository.listOfNew();

	}

	// list of buy with phone//
	@GetMapping("/phone-buy-with-accessories")
	public List<Product> getPAC() {

		return productRepository.listByWith();

	}

	// list of buy with phone//
	@GetMapping("/laptop-buy-with-accessories")
	public List<Product> getLAC() {

		return productRepository.listLapByWith();

	}
	// list of buy with phone//
		@GetMapping("/order-detail-product/{id}")
		public List<Product> getProductOrrder(@PathVariable String id) {

			return productRepository.listProductOrder(id);

		}

	@RequestMapping("/filter")
	public List<Product> viewFilter(@Param("price_small") Double price_small, @Param("price_large") Double price_large,
			@Param("brand") String brand) {
		List<Product> list = new ArrayList<Product>();
		String s2="none";
		
		if ((s2.compareTo(brand)==0)&&price_large!=0) {
			
			List<Product> listProducts = productRepository.FilterPrice(price_small, price_large);
			list = listProducts;
		}
		if (price_large == 0 && (s2.compareTo(brand)!=0)) {
			List<Product> listProducts = productRepository.FilterBrand(brand);
			list = listProducts;
		}
		
		if (price_large != 0 && (s2.compareTo(brand)!=0)) {
			List<Product> listProducts = productRepository.Filter(price_small, price_large, brand);
			list = listProducts;
		}
		if (price_large == 0 && (s2.compareTo(brand)==0)) {
			List<Product> listProducts = productRepository.listPhone();
			list = listProducts;
		}
		return list;
	}

	@RequestMapping("/filter/phone-brand")
	public List<Product> viewFilterPhoneBrand(
			@Param("brand") String brand) {
		
			List<Product> listProducts = productRepository.FilterBrand(brand);
		return listProducts;
	}
	///Review
	@GetMapping("/review-productid/{id}")
	public Review getReview(@PathVariable(value = "id") Long id) {

		return reviewRepository.getReview(id);

	}


}
