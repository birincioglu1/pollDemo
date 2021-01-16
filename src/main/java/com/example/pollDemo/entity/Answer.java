package com.example.pollDemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answer")
public class Answer extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int id;
	private String content;
	private int count;
	private String photo;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "poll_id")
	private Poll poll;

	@JsonManagedReference
	@OneToMany(mappedBy = "answer")
	private List<Vote> votes=new ArrayList<Vote>();
	
	public void addVote(Vote vote)
	{
		this.votes.add(vote);
	}
}
