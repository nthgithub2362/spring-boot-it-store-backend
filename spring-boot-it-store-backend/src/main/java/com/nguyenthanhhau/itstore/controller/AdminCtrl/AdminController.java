package com.nguyenthanhhau.itstore.controller.AdminCtrl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.nguyenthanhhau.itstore.controller.ApiResponse;
import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.entity.ProductRelated;
import com.nguyenthanhhau.itstore.entity.Review;
import com.nguyenthanhhau.itstore.entity.images.ImageProduct;
import com.nguyenthanhhau.itstore.exception.ResourceNotFoundException;
import com.nguyenthanhhau.itstore.repository.ImageRepository;
import com.nguyenthanhhau.itstore.repository.ProductRelatedRepository;
import com.nguyenthanhhau.itstore.repository.ProductRepository;
import com.nguyenthanhhau.itstore.repository.ReviewRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin/")
public class AdminController {
	private static String imageDirectory = System.getProperty("user.dir") + "/images/";
	@Autowired
	private ProductRepository productReponsitory;
	@Autowired
	private ProductRelatedRepository productRelatedRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ReviewRepository reviewRepository;

//get-product-by-id
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productReponsitory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exits with id:" + id));
		return ResponseEntity.ok(product);
	}

	// save-product
	@PostMapping("/addProduct")
	public Product createProduct(@RequestBody Product product) {
		List<ProductRelated> productrelated = new ArrayList<ProductRelated>();
		List<ImageProduct> productimage = new ArrayList<ImageProduct>();
		product.setProductrelate(new HashSet<ProductRelated>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5619441967802709713L;
			{
				for (ProductRelated news2 : productrelated) {

					add(news2);
				}

			}
		});
		product.setProductimage(new HashSet<ImageProduct>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5619441967802709713L;

			{
				for (ImageProduct news2 : productimage) {

					add(news2);
				}

			}
		});
		product.setReview(new Review());
		return productReponsitory.save(product);
	}

	// up nhieu anh trong product
	@PostMapping(value = "/add-product-image/{id}", produces = { MediaType.IMAGE_PNG_VALUE, "application/json" })
	public ResponseEntity<?> uploadImage(@RequestParam("imageFile") MultipartFile file,
			// de phan biet la up load anh lien quan hay anh project
			@RequestParam("type") int type, @PathVariable("id") long productId) {
		makeDirectoryIfNotExist(imageDirectory);
		String fileName = file.getOriginalFilename();
		System.out.println("fileName: " + fileName);
		Path fileNamePath = Paths.get(imageDirectory, fileName);
		try {
			Files.write(fileNamePath, file.getBytes());
			// up anh lien quan
			if (type == 0) {

				ImageProduct imageProduct = new ImageProduct(fileName, new Product(productId));
				imageRepository.save(imageProduct);
			} else {
				// up anh product
				Product product = productReponsitory.findById(productId).get();
				product.setImage(fileName);
				productReponsitory.save(product);
			}

			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IOException ex) {
			return new ResponseEntity<>("Image is not uploaded", HttpStatus.BAD_REQUEST);
		}
	}

	private void makeDirectoryIfNotExist(String imageDirectory) {
		File directory = new File(imageDirectory);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	@PostMapping(value = "/addimage", produces = { MediaType.IMAGE_PNG_VALUE, "application/json" })
	public ResponseEntity<?> uploadImage(@RequestParam("imageFile") MultipartFile file) {
		makeDirectoryIfNotExist(imageDirectory);
		String fileName = file.getOriginalFilename();
		System.out.println("fileName: " + fileName);
		Path fileNamePath = Paths.get(imageDirectory, fileName);
		try {
			Files.write(fileNamePath, file.getBytes());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IOException ex) {
			return new ResponseEntity<>("Image is not uploaded", HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/product-images/{id}")
	public ResponseEntity<?> setProductImage(@PathVariable(value = "id") Long Id,
			@RequestBody List<ImageProduct> images) {
		Product product = productReponsitory.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id : " + Id));
		product.getProductimage().clear();
		for (ImageProduct news2 : images) {
			product.getProductimage().add(news2);
		}
		imageRepository.saveAll(images);
		return ResponseEntity.ok(new ApiResponse("Save productImage successfully", ""));
	}

	@PutMapping("/productrelated/{id}")
	public ResponseEntity<?> setProductrelated(@PathVariable(value = "id") Long Id,
			@RequestBody List<ProductRelated> productRelateds) {
		Product product = productReponsitory.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id : " + Id));
		product.getProductrelate().clear();
		for (ProductRelated news2 : productRelateds) {

			product.getProductrelate().add(news2);
		}
		productRelatedRepository.saveAll(productRelateds);
		return ResponseEntity.ok(new ApiResponse("Save ProductRelated successfully", ""));
	}
	@PutMapping("/admin-review/{id}")
	public ResponseEntity<?> setReview(@PathVariable(value = "id") Long Id,
			@RequestBody Review review) {
		Product product = productReponsitory.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id : " + Id));


			product.setReview(review);
			review.setProduct(product);
	
			reviewRepository.save(review);
		return ResponseEntity.ok(new ApiResponse("Save Review successfully", ""));
	}

	// update employee rest api
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateEmployee(@PathVariable Long id, @RequestBody Product productDetails) {
		Product product = productReponsitory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exits with id:" + id));
		product.setName(productDetails.getName());
		product.setTitle(productDetails.getTitle());
		product.setDescription(productDetails.getDescription());
		product.setParamater(productDetails.getParamater());
		product.setImage(productDetails.getImage());
		product.setBrand(productDetails.getBrand());
		product.setPrice(productDetails.getPrice());
		product.setPrice_net(productDetails.getPrice_net());
		product.setAvailable(productDetails.getAvailable());
		product.setSold(productDetails.getSold());
		product.setDeal_timer(productDetails.getDeal_timer());
		product.setCateid(productDetails.getCateid());
		product.setEvent(productDetails.getEvent());
		product.setGift(productDetails.getGift());
		product.setPromotion(productDetails.getPromotion());

		Product updatedproduct = productReponsitory.save(product);
		return ResponseEntity.ok(updatedproduct);
	}

	// create employee rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Product product = productReponsitory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exits with id:" + id));

		productReponsitory.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	// xóa đánh giá
	@DeleteMapping("/review-product/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteReview(@PathVariable Long id) {
		Review review = reviewRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Review not exits with id:" + id));

		reviewRepository.delete(review);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	// get-all-admin-product
	@GetMapping("/all-product")
	Page<Product> getAllProduct(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
		return productReponsitory.findAll(PageRequest.of(page.orElse(1), 10, Sort.Direction.ASC, sortBy.orElse("id")));
	}

}
