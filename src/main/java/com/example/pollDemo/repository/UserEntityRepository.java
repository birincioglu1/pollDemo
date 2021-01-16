package com.example.pollDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pollDemo.entity.User;

public interface UserEntityRepository extends JpaRepository<User,Long> {
	
	User findByUsername(String username);

}
