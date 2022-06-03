package com.assignment.Product;

@RestController
public class ProductController {
	
	@Autowired
    private ProductService service;
	
	@GetMapping("/api/products?page=2")
	public List<Product> list() {
	    return service.listAll();
	}
	
	@GetMapping("/api/products/{di}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
	    try {
	        Product product = service.get(id);
	        return new ResponseEntity<Product>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/api/products")
	public void add(@RequestBody Product product) {
	    service.save(product);
	}
	
	@PutMapping("/api/categories/{di}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
	    try {
	        Product existProduct = service.get(id);
	        service.save(product);
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
