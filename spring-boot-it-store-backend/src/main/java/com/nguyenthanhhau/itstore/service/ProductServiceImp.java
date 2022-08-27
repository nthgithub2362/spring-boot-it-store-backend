package com.nguyenthanhhau.itstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	  @Autowired
	    private ProductRepository productReponsitory;
	//Search Product
	  public List<Product> listAll(String keyword) {
	        if (keyword != null) {
	            return productReponsitory.findByNameContainsIgnoreCase(keyword);
	        }
	        return productReponsitory.findAll();
	    }
	 
		
		public Product getProductsById(long productId) throws Exception {
			return productReponsitory.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
		}
}
