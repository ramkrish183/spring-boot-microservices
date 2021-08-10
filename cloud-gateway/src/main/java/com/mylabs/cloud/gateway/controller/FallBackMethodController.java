package com.mylabs.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallbackMethod")
	public String userServiceFallBackMethodController() {
		return "user service is down";
	}
	
	@GetMapping("/productServiceFallbackMethod")
	public String productServiceFallBackMethodController() {
		return "Product service is down";
	}
}
