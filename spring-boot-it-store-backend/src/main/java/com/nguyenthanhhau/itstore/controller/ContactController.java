package com.nguyenthanhhau.itstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.exception.ResourceNotFoundException;
import com.nguyenthanhhau.itstore.entity.Category;
import com.nguyenthanhhau.itstore.entity.Contact;
import com.nguyenthanhhau.itstore.entity.New;
import com.nguyenthanhhau.itstore.repository.CategoryRepository;
import com.nguyenthanhhau.itstore.repository.ContactRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ContactController {
	@Autowired
	private ContactRepository contactRepository;
	// create employee rest api
		@PostMapping("/contact")
		public Contact createContact(@RequestBody Contact contact) {
			return contactRepository.save(contact);
		}
		
		// get employee by id rest api
		@GetMapping("/contact/{id}")
		public ResponseEntity<Contact> getEmployeeById(@PathVariable Long id) {
			Contact contact = contactRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id :" + id));
			return ResponseEntity.ok(contact);
		}
		
		// update employee rest api
		
//		@PutMapping("/contact/{id}")
//		public ResponseEntity<Contact> updateEmployee(@PathVariable Long id, @RequestBody Contact employeeDetails){
//			Contact contact = employeeRepository.findById(id)
//					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//			
//			contact.setFirstName(employeeDetails.getFirstName());
//			contact.setLastName(employeeDetails.getLastName());
//			contact.setEmailId(employeeDetails.getEmailId());
//			
//			Employee updatedEmployee = employeeRepository.save(employee);
//			return ResponseEntity.ok(updatedEmployee);
//		}
		
		// delete employee rest api
		@DeleteMapping("/contact/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable Long id){
			Contact employee = contactRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id :" + id));
			
			contactRepository.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		@GetMapping("/contact-new")
		public List<Contact> listContactNew(){
			return contactRepository.listContactNew();
		}

}
