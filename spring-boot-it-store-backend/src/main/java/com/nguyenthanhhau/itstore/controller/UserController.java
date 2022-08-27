package com.nguyenthanhhau.itstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.entity.User;
import com.nguyenthanhhau.itstore.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all-user")
	Page<User> getAllUser(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
		return userRepository.findAll(PageRequest.of(page.orElse(1), 10, Sort.Direction.ASC, sortBy.orElse("id")));
	}
	
}
