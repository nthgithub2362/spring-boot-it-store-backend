package com.nguyenthanhhau.itstore.controller.shoppingcart;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.entity.Order;
import com.nguyenthanhhau.itstore.entity.OrderDetail;
import com.nguyenthanhhau.itstore.exception.ResourceNotFoundException;
import com.nguyenthanhhau.itstore.repository.OrderDetailRepository;







@RestController
@CrossOrigin
public class OrderDetailController {
	@Autowired
	private OrderDetailRepository orderRes;

	@PostMapping("/order")
	public void Test(@RequestBody List<OrderDetail> myOrder) {
		orderRes.saveAll(myOrder);
	}
	// get list product order
	@GetMapping("/list_order/list_product/{id}")
	public List<OrderDetail> getListOrderDetail(@PathVariable(value = "id") String id) {
		return orderRes.getListOrderDetail(id);
	}
	@DeleteMapping("/order_detail/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOrderDe(@PathVariable String id) {
		List<OrderDetail> orderDetail= orderRes.getListOrderDetail(id);

		orderRes.deleteAll(orderDetail);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/order/chart")
	public List<OrderDetail> getListOrderDetailChart() {
		return orderRes.getListOrderDetailChart();
	}

}
