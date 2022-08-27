package com.nguyenthanhhau.itstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.nguyenthanhhau.itstore.entity.Contact;
import com.nguyenthanhhau.itstore.entity.New;
import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.exception.ResourceNotFoundException;
import com.nguyenthanhhau.itstore.repository.ContactRepository;
import com.nguyenthanhhau.itstore.repository.NewRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NewController {
	@Autowired
	private NewRepository newRepository;
	
	// create new rest api
		@PostMapping("/addNew")
		public New createContact(@RequestBody New news) {
			return newRepository.save(news);
		}
		
		// get new by id rest api
		@GetMapping("/new/{id}")
		public ResponseEntity<New> getNewSById(@PathVariable Long id) {
			New news = newRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("News not exist with id :" + id));
			return ResponseEntity.ok(news);
		}
		
		// update new rest api
		
		@PutMapping("/updateNew/{id}")
		public ResponseEntity<New> updateNew(@PathVariable Long id, @RequestBody New newDetails){
			New news = newRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("News not exist with id :" + id));
			
			news.setName(newDetails.getName());
			news.setTitle(newDetails.getTitle());
			news.setImage(newDetails.getImage());
			news.setType(newDetails.getTitle());
			news.setDescription(newDetails.getDescription());
			
			New updateNew = newRepository.save(news);
			
			return ResponseEntity.ok(updateNew);
		}
		
		// delete employee rest api
		@DeleteMapping("/deleteNew/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteNew(@PathVariable Long id){
			New news = newRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("News not exist with id :" + id));
			
			newRepository.delete(news);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		

		
	@GetMapping("/news")
	 Page<New> getAllNew(
	            @RequestParam Optional<Integer> page,
	            @RequestParam Optional<String> sortBy
	    ) {
	        return newRepository.findAll(
	                PageRequest.of(
	                        page.orElse(1),
	                        4,
	                        Sort.Direction.ASC, sortBy.orElse("id")
	                )
	        );
	    }
	// get all news
		@GetMapping("/news/detail-new/{id}")
		public ResponseEntity<New> getNewById(@PathVariable Long id) {
			New news = newRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("New not exist with id :" + id));
			return ResponseEntity.ok(news);
		}
		//get List type
		@GetMapping("/news/phone")
		public List<New> getNewsPhone(){
			return newRepository.listNewPhone();
		}
		@GetMapping("/news/lap")
		public List<New> getNewsLap(){
			return newRepository.listLap();
		}
		@GetMapping("/news/watch")
		public List<New> getNewsWactch(){
			return newRepository.listWatc();
		}
		@GetMapping("/news-highlight")
		public New getNewHlight(){
			return newRepository.newHlight();
		}
		@GetMapping("/news-list-light")
		public List<New> getListNewHlight(){
			return newRepository.listnewHlight();
		}
		@GetMapping("/news-list-new")
		public List<New> getListNewRight(){
			return newRepository.listnewRight();
		}
		@GetMapping("/news-list-pro")
		public List<New> getNewPro(){
			return newRepository.listnewPro();
		}
		@GetMapping("/news-list-tips")
		public List<New> getNewTips(){
			return newRepository.listTips();
		}
}
