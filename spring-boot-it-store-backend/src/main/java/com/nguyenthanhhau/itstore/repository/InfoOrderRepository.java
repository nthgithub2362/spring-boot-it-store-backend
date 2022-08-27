package com.nguyenthanhhau.itstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.Order;

@Repository
public interface InfoOrderRepository extends JpaRepository<Order, Long>{
	@Query(value="SELECT * FROM info_order where info_order.user_id=?1 ", nativeQuery = true)
	public List<Order> ListOrder(Long id);
	
	@Query(value="SELECT * FROM info_order where info_order.id_order=?1 ", nativeQuery = true)
	public Order getOrder(String id);
	

}

