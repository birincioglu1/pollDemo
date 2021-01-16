package com.example.pollDemo.business;

import java.util.List;

import com.example.pollDemo.entity.Poll;

import com.example.pollDemo.model.CustomPollVote;


public interface IPollService {

	
	List<Poll> getAll();
	void addPoll(Poll poll);
	void deletePoll(int pollId);
	void updatePoll(Poll poll);
	Poll pollFindById(int pollId);
	void addVote(CustomPollVote customVote);
	
	
	
}
