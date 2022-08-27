package com.nguyenthanhhau.itstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	@Query(value="SELECT * FROM review where review.product_id=?1 and review.id=(Select max(id) from review where review.product_id=?1) ", nativeQuery = true)
	public Review getReview(long id);
}
