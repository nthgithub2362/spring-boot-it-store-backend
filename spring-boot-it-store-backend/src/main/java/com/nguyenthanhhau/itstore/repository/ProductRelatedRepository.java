package com.nguyenthanhhau.itstore.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.nguyenthanhhau.itstore.entity.ProductRelated;



@Repository
public interface ProductRelatedRepository extends JpaRepository<ProductRelated, Long>{
	
}
