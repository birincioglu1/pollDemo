package com.example.pollDemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomPollVote {
	
	private int pollId;
	private int answerId;
	private long userId;
	
	public CustomPollVote(int pollId, int answerId, long userId) {
		
		this.pollId = pollId;
		this.answerId = answerId;
		this.userId = userId;
	}
	
	


}
