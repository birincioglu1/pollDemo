package com.example.pollDemo.repository;


import com.example.pollDemo.entity.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactEntityRepository extends JpaRepository<UserContact, Integer> {
	


}
