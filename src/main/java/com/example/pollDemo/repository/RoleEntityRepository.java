package com.example.pollDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pollDemo.entity.Role;

public interface RoleEntityRepository extends JpaRepository<Role, Integer> {
	
	Role findByName(String name);

}
