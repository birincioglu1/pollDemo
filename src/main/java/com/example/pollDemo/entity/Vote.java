package com.example.pollDemo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vote")
public class Vote extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vote_id")
	private int id;
	
	private long userId;
	
//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name = "poll_id")
//	private Poll poll;
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "answer_id")
	private Answer answer;
}
