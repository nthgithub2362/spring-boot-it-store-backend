package com.nguyenthanhhau.itstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenthanhhau.itstore.entity.Order;
import com.nguyenthanhhau.itstore.entity.OrderDetail;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	@Query(value="SELECT * FROM order_detail where order_detail.id_order=?1 ", nativeQuery = true)
	public List<OrderDetail> getListOrderDetail(String id);
	
	@Query(
			  value = "SELECT e.id_detail_order,e.id,e.price,e.id_order,e.quantity, Sum(e.quantity) as 'Tong' FROM order_detail e GROUP BY e.id,e.id_detail_order", 
			 
			  nativeQuery = true)
	public List<OrderDetail> getListOrderDetailChart();
	
}
