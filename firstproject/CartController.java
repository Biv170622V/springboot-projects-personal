package com.example.firstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController{
	
	@Autowired
	private CartService cartService;
	
	//Create a new cart
	@PostMapping
	public Cart createCart() {
		return cartService.createCart();
	}
	
	//add product to cart
	@PostMapping("/{cartId}/addProduct/{productId}")
	public Cart addProductToCart(@PathVariable Long cartId,@PathVariable Long productId) {
		return cartService.addProductToCart(cartId, productId);
	}
	
	//remove product from cart
	@DeleteMapping("/{cartId}/removeProduct/{productId}")
	public Cart removeProductFromCart(@PathVariable Long cartId,@PathVariable Long productId) {
		return cartService.removeProductFromCart(cartId, productId);
	}
	
	//Get cart details
	@GetMapping("/{cartId}")
	public Cart getCartById(@PathVariable Long cartId) {
		return cartService.getCartById(cartId);
	}
	
	//Handle general errors in a centralized way
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException ex) {
		return ex.getMessage();
	}
}