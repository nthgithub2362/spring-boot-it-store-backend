package com.nguyenthanhhau.itstore.controller.shoppingcart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.entity.Order;
import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.exception.ResourceNotFoundException;
import com.nguyenthanhhau.itstore.repository.InfoOrderRepository;

@RestController
@CrossOrigin
public class InfoOrderController {
	@Autowired
	private InfoOrderRepository infoRepository;

	
		@PostMapping("/info_order")
		public Order createForm(@RequestBody Order info) {
			return infoRepository.save(info);
		}
		@DeleteMapping("/info_order/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable String id) {
			Order order = infoRepository.getOrder(id);
					

			infoRepository.delete(order);
			Map<String, Boolean> response = new HashMap<>();
			response.put("delete", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		@GetMapping("/order-list")
	    Page<Order> getAllOrder(
	            @RequestParam Optional<Integer> page,
	            @RequestParam Optional<String> sortBy
	    ) {
	        return infoRepository.findAll(
	                PageRequest.of(
	                        page.orElse(1),
	                        12,
	                        Sort.Direction.ASC, sortBy.orElse("id")
	                )
	        );
	    }
		//Update cancel
		@PutMapping("/order/{id}")
		public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order orderDetail) {
			Order order = infoRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Order not exits with id:" + id));
			order.setStatus(false);
			
			
			Order updatedorder = infoRepository.save(order);
			return ResponseEntity.ok(updatedorder);
		}
		@PutMapping("/order-rehibilitate/{id}")
		public ResponseEntity<Order> rehibilitate(@PathVariable Long id, @RequestBody Order orderDetail) {
			Order order = infoRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Order not exits with id:" + id));
			order.setStatus(true);
			
			
			Order updatedorder = infoRepository.save(order);
			return ResponseEntity.ok(updatedorder);
		}
		
}