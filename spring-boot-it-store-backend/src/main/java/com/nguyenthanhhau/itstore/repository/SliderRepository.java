package com.nguyenthanhhau.itstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.entity.Slider;

@Repository
public interface SliderRepository extends JpaRepository<Slider, Long>{
	@Query(value="SELECT * FROM slider where slider.title='home'", nativeQuery = true)
	public List<Slider> SliderHome();
	@Query(value="SELECT * FROM slider where slider.title='phone'", nativeQuery = true)
	public List<Slider> SlidePhone();
	@Query(value="SELECT * FROM slider where slider.title='laptop'", nativeQuery = true)
	public List<Slider> SliderLaptop();
	@Query(value="SELECT * FROM slider where slider.title='watch'", nativeQuery = true)
	public List<Slider> SliderWatch();
	@Query(value="SELECT * FROM slider where slider.title='accessorie'", nativeQuery = true)
	public List<Slider> SliderAccessories();
}
