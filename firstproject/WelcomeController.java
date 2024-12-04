package com.example.firstproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class WelcomeController{
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to spring boot app development personal project";
		
	}
	
	//Get all products
	@GetMapping("/all")
	public List<product> getAllProducts(){
		return productRepository.findAll();
	}
	
	//get product by id
	@GetMapping("/{id}")
	public product getProductById(@PathVariable Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	//post a new product
	@PostMapping("/add")
	public product createProduct(@RequestBody product Product) {
		return productRepository.save(Product);
	}
	
	//PUT to update an existing product
	@PutMapping("/{id}")
	public product updateProduct(@PathVariable Long id,@RequestBody product updatedProduct) {
		Optional<product> existingProduct = productRepository.findById(id);
		if(existingProduct.isPresent()) {
			product Product = existingProduct.get();
			Product.setName(updatedProduct.getName());
			Product.setPrice(updatedProduct.getPrice());
			Product.setDescription(updatedProduct.getDescription());
			return productRepository.save(Product);
		} else {
		return null;
		}
	}
	
	//delete a product by ID
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return "Product deleted successfully";
		} else {
			return "Product not found";
		}
	}
	
}