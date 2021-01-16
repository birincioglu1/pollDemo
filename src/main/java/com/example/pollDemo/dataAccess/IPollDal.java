package com.example.pollDemo.dataAccess;

import java.util.List;

import com.example.pollDemo.entity.Answer;
import com.example.pollDemo.entity.Poll;
import com.example.pollDemo.entity.Vote;


public interface IPollDal {

	
	List<Poll> getAll();
	void addPoll(Poll poll);
	void deletePoll(int pollId);
	void updatePoll(Poll poll);
	Poll pollFindById(int pollId);
	void addVote(Vote vote);
	Answer asnwerFindById(int answerId);
	void addAnswer(Answer answer);
	void updateAnswer(Answer answer);
}
