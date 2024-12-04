package com.example.firstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public Cart addProductToCart(Long CartId,Long productId) {
		Cart cart = cartRepository.findById(CartId).orElseThrow(()-> new RuntimeException("Cart not found"));
		product Product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
		
		cart.getProducts().add(Product);
		updateTotalPrice(cart);
		return cartRepository.save(cart);
		
	}
	
	@Transactional
	public Cart removeProductFromCart(Long CartId,Long productId) {
		Cart cart = cartRepository.findById(CartId).orElseThrow(()-> new RuntimeException("Cart not found"));
		product Product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("product not found"));
		
		if(cart.getProducts().remove(Product)) {
			updateTotalPrice(cart);
			return cartRepository.save(cart);
		} else {
			throw new RuntimeException("Product not in cart");
		}
	}
	
	private void updateTotalPrice(Cart cart) {
		double totalPrice = cart.getProducts().stream().mapToDouble(product::getPrice)
				.sum();
		cart.setTotalPrice(totalPrice);
		
	}
	
	@Transactional
	public Cart getCartById(Long cartId) {
		return cartRepository.findById(cartId).orElseThrow(()-> new RuntimeException("Cart not found"));
		
	}

	public Cart createCart() {
		Cart cart= new Cart();
		return cartRepository.save(cart);
	}

	
}