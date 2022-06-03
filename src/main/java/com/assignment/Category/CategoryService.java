package com.assignment.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.Product.Product;
import com.assignment.Product.ProductRepo;

public class CategoryService {
	
	@Autowired
    private CategoryRepo repo;
     
    public List<Category> listAll() {
        return repo.findAll();
    }
     
    public void save(Category category) {
        repo.save(product);
    }
     
    public Product get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
