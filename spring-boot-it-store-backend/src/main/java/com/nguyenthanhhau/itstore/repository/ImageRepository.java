package com.nguyenthanhhau.itstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.images.ImageProduct;

@Repository
public interface ImageRepository extends JpaRepository<ImageProduct, Long> {

}
