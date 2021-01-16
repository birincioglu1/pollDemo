package com.example.pollDemo.repository;

import com.example.pollDemo.entity.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationEntityRepository extends JpaRepository<UserLocation, Integer> {
	


}
