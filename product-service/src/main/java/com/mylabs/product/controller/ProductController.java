package com.mylabs.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mylabs.product.entity.Product;
import com.mylabs.product.entity.User;
import com.mylabs.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productservice;

	@GetMapping("/say")
	public String sayHello() {
		return "Hello";
	}
	@PostMapping(path = "/getUser")
	@ResponseBody
	public User getUser(@RequestBody Product product) {
		System.out.println(product);
		User newUser=new User();
		newUser.setFirstName("Ramesh");
		newUser.setLastName("Jeyaprakash");
		return newUser;
	}
	@PostMapping(path = "/", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		System.out.println("Request to save "+product);
		Product out=productservice.saveProduct(product);
		return new ResponseEntity<>(out,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Product findByProductId(@PathVariable("id") Long productId) {
		System.out.println("Request to find "+productId);
		Product out= productservice.findByProductId(productId);
		return out;
	}
}
