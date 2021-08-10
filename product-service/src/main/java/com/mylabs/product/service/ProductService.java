package com.mylabs.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mylabs.product.entity.Product;
import com.mylabs.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product saveProduct(Product product) {
		//log.info("Inside saveDepartment of DepartmentService");
		return productRepository.save(product);
	}
	
	public Product findByProductId(Long productId) {
		return productRepository.findByProductId(productId);
	}
}
