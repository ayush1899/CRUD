package com.assignment.Category;

import com.assignment.Product.Entity;
import com.assignment.Product.GeneratedValue;
import com.assignment.Product.Id;

@Entity
public class Category {
    private Integer id;
    private String name;
 
    public Product() {
    }
 
    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
