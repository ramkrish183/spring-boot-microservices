package com.mylabs.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mylabs.userservice.entity.User;
import com.mylabs.userservice.repository.UserRepository;
import com.mylabs.userservice.vo.Product;
import com.mylabs.userservice.vo.ResponseVO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	public User findUserById(int userId) {
		return userRepository.findByUserId(userId);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public ResponseVO getUserandProducts(int userId) {
		ResponseVO responseVo = new ResponseVO();
		User user = userRepository.findByUserId(userId);

		Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + user.getProductID(),
				Product.class);

		responseVo.setProduct(product);
		responseVo.setUser(user);
		return responseVo;
	}

}
