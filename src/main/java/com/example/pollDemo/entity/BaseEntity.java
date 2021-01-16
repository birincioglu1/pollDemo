package com.example.pollDemo.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
	
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date updatedDate;
	

}
