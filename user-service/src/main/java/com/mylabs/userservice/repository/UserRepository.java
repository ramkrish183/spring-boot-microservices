package com.mylabs.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mylabs.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserId(int userId);
}
