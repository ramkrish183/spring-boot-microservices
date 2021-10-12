package com.mylabs.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mylabs.userservice.entity.User;
import com.mylabs.userservice.repository.UserRepository;
import com.mylabs.userservice.service.UserService;
import com.mylabs.userservice.vo.Product;
import com.mylabs.userservice.vo.ResponseVO;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {
	private final String PRODUCT_FALLBACKSERVICE="productFallBackService";
	@Autowired
	private UserService userService;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/{id}")
	//@CircuitBreaker(name=PRODUCT_FALLBACKSERVICE, fallbackMethod="productServiceFallBackMethod")
	public ResponseVO getData(@PathVariable("id") int userId) {
		ResponseVO responseVo = new ResponseVO();
		User user = userRepository.findByUserId(userId);
		Assert.state(user != null, "Request URI does not contain a valid hostname: ");
		//http://localhost:9091/products/1
		Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + user.getProductID(),
				Product.class);
		responseVo.setProduct(product);
		responseVo.setUser(user);
		return responseVo;
	}
	
	public ResponseEntity<String> productServiceFallBackMethod(Exception e){
		return new ResponseEntity<String>("Service is down ",HttpStatus.OK);
		
	}
	
	@GetMapping("/hello")
	
	public String sayHello() {
		Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + 1,
				Product.class);
		return "Hello";
	}
	public ResponseEntity<String> newFallBackMethod(Exception e){
		return new ResponseEntity<String>("Service is down ",HttpStatus.OK);
		
	}
	
	
	
}
