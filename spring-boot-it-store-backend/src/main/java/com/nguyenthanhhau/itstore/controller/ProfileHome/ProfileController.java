package com.nguyenthanhhau.itstore.controller.ProfileHome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.entity.Order;
import com.nguyenthanhhau.itstore.entity.OrderDetail;
import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.entity.User;
import com.nguyenthanhhau.itstore.exception.ResourceNotFoundException;
import com.nguyenthanhhau.itstore.payload.request.LoginRequest;
import com.nguyenthanhhau.itstore.payload.response.MessageResponse;
import com.nguyenthanhhau.itstore.repository.InfoOrderRepository;
import com.nguyenthanhhau.itstore.repository.OrderDetailRepository;
import com.nguyenthanhhau.itstore.repository.UserRepository;
import com.nguyenthanhhau.itstore.service.UserDetailsImpl;
import com.nguyenthanhhau.itstore.security.jwt.JwtUtils;

@RestController
@CrossOrigin
public class ProfileController {
	@Autowired
	private InfoOrderRepository infoRepository;
	private OrderDetailRepository orderDe;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtils jwtUtils;
	// get all order
	@GetMapping("/list_order/{id}")
	public List<Order> getAllOrder(@PathVariable(value = "id") Long id) {
		return infoRepository.ListOrder(id);
	}
	@Autowired
	PasswordEncoder encoder;
	// get order
	@GetMapping("/list_order/detail_order/{id}")
	public Order getOrder(@PathVariable(value = "id") String id) {
		return infoRepository.getOrder(id);
	}
	//get-product-by-id
		@GetMapping("/change_user/{id}")
		public ResponseEntity<User> getProductById(@PathVariable Long id) {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exits with id:" + id));
			return ResponseEntity.ok(user);
		}
	// update employee rest api
		@PutMapping("/change_user/{id}")
		public ResponseEntity<User> updateEmployee(@PathVariable Long id, @RequestBody User userDetails) {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exits with id:" + id));
			user.setUsername(userDetails.getUsername());
			user.setAddress(userDetails.getAddress());
			user.setEmail(userDetails.getEmail());
			user.setPhone(userDetails.getPhone());
			User updateUser = userRepository.save(user);
			return ResponseEntity.ok(updateUser);
		}
		// update user admin rest api
				@PutMapping("/update-user/{id}")
				public ResponseEntity<User> updateUserAdmin(@PathVariable Long id, @RequestBody User userDetails) {
					User user = userRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("User not exits with id:" + id));
					user.setUsername(userDetails.getUsername());
					user.setAddress(userDetails.getAddress());
					user.setEmail(userDetails.getEmail());
					user.setPassword(encoder.encode(userDetails.getPassword()));
					user.setPhone(userDetails.getPhone());
					User updateUser = userRepository.save(user);
					return ResponseEntity.ok(updateUser);
				}
		@PutMapping("/change_user/{id}/{np}")
		public ResponseEntity<?> updatepassword(@PathVariable (value="id") Long id, @Valid @RequestBody User useDetails,@PathVariable (value="np") String password)
		throws ResourceNotFoundException{
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not exits with id:" + id));
			
		
			

			
//			if(userDetail.getPassword()))
//			{
//				
//				user.setPassword(encoder.encode(password));
//			}else {
//				return ResponseEntity.badRequest().body(new MessageResponse("Mật khẩu không chính xác"));
//			}
//			
//			final User updateUser = userRepository.save(user);
			return ResponseEntity.ok(new MessageResponse("Đổi mật khẩu thành công"));
		}
	
	

}