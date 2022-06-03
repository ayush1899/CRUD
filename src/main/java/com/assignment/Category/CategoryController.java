package com.assignment.Category;

import com.assignment.Category.Autowired;
import com.assignment.Category.DeleteMapping;
import com.assignment.Category.GetMapping;
import com.assignment.Category.List;
import com.assignment.Category.NoSuchElementException;
import com.assignment.Category.PathVariable;
import com.assignment.Category.PostMapping;
import com.assignment.Category.Category;
import com.assignment.Category.CategoryService;
import com.assignment.Category.PutMapping;
import com.assignment.Category.RequestBody;
import com.assignment.Category.ResponseEntity;
import com.assignment.Category.RestController;

@RestController
public class CategoryController {
	
	@Autowired
    private CategoryService service;
	
	@GetMapping("/api/categories?page=3")
	public List<Category> list() {
	    return service.listAll();
	}
	
	@GetMapping("/api/categories/{di}")
	public ResponseEntity<Category> get(@PathVariable Integer id) {
	    try {
	        Category Category = service.get(id);
	        return new ResponseEntity<Category>(Category, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/api/categories")
	public void add(@RequestBody Category Category) {
	    service.save(Category);
	}
	
	@PutMapping("/api/categories/{di}")
	public ResponseEntity<?> update(@RequestBody Category Category, @PathVariable Integer id) {
	    try {
	        Category existCategory = service.get(id);
	        service.save(Category);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/api/categories/{di}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}

}

