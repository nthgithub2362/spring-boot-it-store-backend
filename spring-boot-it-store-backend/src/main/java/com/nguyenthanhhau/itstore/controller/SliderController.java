package com.nguyenthanhhau.itstore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.entity.Slider;
import com.nguyenthanhhau.itstore.repository.ProductRelatedRepository;
import com.nguyenthanhhau.itstore.repository.ProductRepository;
import com.nguyenthanhhau.itstore.repository.SliderRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SliderController {
	@Autowired
	private SliderRepository sliderRepository;
	


	
	// get for home
	@GetMapping("/sliders")
	public List<Slider> getAllSlider(){
		return sliderRepository.SliderHome();
	}
	// get for page phone
	@GetMapping("/sliders-phone")
	public List<Slider> getFPhone(){
		return sliderRepository.SlidePhone();
	}
	// get for page for laptop
	@GetMapping("/sliders-laptop")
	public List<Slider> getFLaptop(){
		return sliderRepository.SliderLaptop();
	}
	// get for page for watch
	@GetMapping("/sliders-watch")
	public List<Slider> getFWatch(){
		return sliderRepository.SliderWatch();
	}
	// get for page for accessorie
		@GetMapping("/sliders-accessorie")
		public List<Slider> getFAces(){
			return sliderRepository.SliderAccessories();
		}
	
}