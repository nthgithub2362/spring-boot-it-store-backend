package com.nguyenthanhhau.itstore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.entity.Category;
import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.entity.Slider;
import com.nguyenthanhhau.itstore.entity.logo.Logo;
import com.nguyenthanhhau.itstore.repository.LogoRepository;
import com.nguyenthanhhau.itstore.repository.NewRepository;
import com.nguyenthanhhau.itstore.repository.ProductRelatedRepository;
import com.nguyenthanhhau.itstore.repository.ProductRepository;
import com.nguyenthanhhau.itstore.repository.SliderRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LogoController {
	@Autowired
	private LogoRepository logoRepository;
	
	@GetMapping("/logo-phone")
	public List<Logo> getLogoPhone(){
		return logoRepository.listLogoPhone();
	}
	@GetMapping("/logo-laptop")
	public List<Logo> getLogoLaptop(){
		return logoRepository.listLogoLaptop();
	}
	@GetMapping("/logo-watch")
	public List<Logo> getLogoWatch(){
		return logoRepository.listLogoWatch();
	}
	@GetMapping("/logo-accessorie")
	public List<Logo> getLogoAcce(){
		return logoRepository.listLogoAccess();
	}
}
