package com.nguyenthanhhau.itstore.service;

import java.util.List;

import com.nguyenthanhhau.itstore.entity.Product;

public interface ProductService{

	List<Product> listAll(String name);

}
