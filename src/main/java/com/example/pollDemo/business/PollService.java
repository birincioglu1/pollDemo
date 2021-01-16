package com.example.pollDemo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pollDemo.dataAccess.IPollDal;
import com.example.pollDemo.entity.Answer;
import com.example.pollDemo.entity.Poll;
import com.example.pollDemo.entity.Vote;

import com.example.pollDemo.model.CustomPollVote;

@Service
public class PollService implements IPollService {

	private IPollDal pollDal;
	
	@Autowired
	public PollService(IPollDal pollDal) {

		this.pollDal = pollDal;
	}

	@Override
	public List<Poll> getAll() {
		
		return this.pollDal.getAll();
	}

	@Override
	public void addPoll(Poll poll) {
		this.pollDal.addPoll(poll);
		
	}

	@Override
	public void deletePoll(int pollId) {
		this.pollDal.deletePoll(pollId);
		
	}

	@Override
	public void updatePoll(Poll poll) {
		this.pollDal.updatePoll(poll);
		
	}

	@Override
	public Poll pollFindById(int pollId) {
		
		return this.pollDal.pollFindById(pollId);
	}

	@Override
	public void addVote(CustomPollVote customVote) {
		
		Poll poll=this.pollDal.pollFindById(customVote.getPollId());
		int pollCount=poll.getCount();
		poll.setCount(pollCount+1);
		Answer answer=this.pollDal.asnwerFindById(customVote.getAnswerId());
		int answerCount=answer.getCount();
		answer.setCount(answerCount+1);
		
		Vote vote =new Vote();
		vote.setUserId(customVote.getUserId());
		answer.addVote(vote);
	//	poll.addVote(vote);
		poll.addAnswer(answer);
	
		//vote.setAnswer(answer);
		
	//	vote.setPoll(poll);
		
		this.pollDal.updatePoll(poll);
		
		
	}

	

}
