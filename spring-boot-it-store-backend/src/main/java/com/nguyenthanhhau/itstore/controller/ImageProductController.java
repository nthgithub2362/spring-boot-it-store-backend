package com.nguyenthanhhau.itstore.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.nguyenthanhhau.itstore.entity.images.ImageProduct;
import com.nguyenthanhhau.itstore.repository.ImageRepository;
import com.nguyenthanhhau.itstore.repository.ProductRelatedRepository;
import com.nguyenthanhhau.itstore.repository.ProductRepository;
import com.nguyenthanhhau.itstore.repository.ReviewRepository;
import com.nguyenthanhhau.itstore.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ImageProductController {
	@Autowired
	private ImageRepository imageRepository;

}