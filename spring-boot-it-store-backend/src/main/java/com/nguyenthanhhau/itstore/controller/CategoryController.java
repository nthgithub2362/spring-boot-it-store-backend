package com.nguyenthanhhau.itstore.controller;

import java.awt.print.Pageable;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenthanhhau.itstore.exception.ResourceNotFoundException;
import com.nguyenthanhhau.itstore.entity.Category;
import com.nguyenthanhhau.itstore.entity.Product;
import com.nguyenthanhhau.itstore.repository.CategoryRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	// get all 
	@GetMapping("/c-k")
	public List<Category> getCK(){
		return categoryRepository.Ck();
	}	
	@GetMapping("/c-m")
	public List<Category> getCM(){
		return categoryRepository.Cm();
	}
	@GetMapping("/c-s")
	public List<Category> getCS(){
		return categoryRepository.Cs();
	}	
	@GetMapping("/c-b")
	public List<Category> getCBrand(){
		return categoryRepository.Cb();
	}
	@GetMapping("/c-l")
	public List<Category> getCLap(){
		return categoryRepository.Cl();
	}	
	@GetMapping("/c-p")
	public List<Category> getCPhone(){
		return categoryRepository.Cp();
	}	
	@GetMapping("/categories-admin")
	public List<Category> getAllAdmin(){
		return categoryRepository.findAll();
	}	
	@GetMapping("/categories")
	public List<Category> getAllHome(){
		return categoryRepository.listHome();
	}		
	@GetMapping("/categories/detailpr/{id}")
	public Category CategoryPr(@PathVariable(value = "id") Long id){
		return categoryRepository.CategoryPr(id);
	}
	// create product rest api
	@PostMapping("/addCategories")
	public Category createCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	// get product by id rest api
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("category not exist with id :" + id));
		return ResponseEntity.ok(category);
	}
	
	// update product rest api
	
	@PutMapping("/updateCategories/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails){
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("category not exist with id :" + id));
		
		category.setName(categoryDetails.getName());
		
		category.setId_parent(categoryDetails.getId_parent());
		
		
		Category updatedcategory = categoryRepository.save(category);
		return ResponseEntity.ok(updatedcategory);
	}
	
	// delete product rest api
	@DeleteMapping("/deleteCategories/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Long id){
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("category not exist with id :" + id));
		
		categoryRepository.delete(category);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/admin-categories")
    Page<Category> getAllCateAdmin(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
    ) {
        return categoryRepository.findAll(
                PageRequest.of(
                        page.orElse(1),
                        6,
                        Sort.Direction.ASC, sortBy.orElse("id")
                )
        );
    }
	
	
}
