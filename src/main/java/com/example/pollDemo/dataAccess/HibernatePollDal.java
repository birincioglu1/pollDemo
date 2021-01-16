package com.example.pollDemo.dataAccess;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.pollDemo.entity.Answer;
import com.example.pollDemo.entity.Poll;
import com.example.pollDemo.entity.Vote;

import com.example.pollDemo.model.UserInfo;



@Repository
public class HibernatePollDal implements IPollDal {

	
	private EntityManager entityManager;
	
	@Autowired
	public HibernatePollDal(EntityManager entityManager) {
	
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Poll> getAll() {
		Session session=entityManager.unwrap(Session.class);
	
		
		List<Poll> polls=session.createQuery("from Poll",Poll.class).getResultList();
		return polls;
	}

	@Override
	@Transactional
	public void addPoll(Poll poll) {
		Session session=entityManager.unwrap(Session.class);
		Answer answer=new Answer( );
		answer.setPoll(poll);
		answer.setContent("EVET");
		answer.setCount(1);
		Answer answer2=new Answer( );
		answer2.setPoll(poll);
		answer2.setContent("HAYIR");
		answer2.setCount(1);
		//poll.addAnswer(answer);
	//	poll.addAnswer(answer2);
		
		session.save(answer);
		session.save(answer2);

		session.saveOrUpdate(poll);
		
	}

	@Override
	@Transactional
	public void deletePoll(int pollId) {
		Session session=entityManager.unwrap(Session.class);
		Poll pollDelete=session.get(Poll.class, pollId);
		session.delete(pollDelete);
		
	}

	@Override
	@Transactional
	public void updatePoll(Poll poll) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(poll);
		
	}

	@Override
	@Transactional
	public Poll pollFindById(int pollId) {
		
		Session session=entityManager.unwrap(Session.class);
		Poll poll=session.get(Poll.class, pollId);
		
		return poll;
	}

	@Override
	public void addVote(Vote vote) {
		
		Session session=entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(vote);
		
	}

	@Override
	@Transactional
	public Answer asnwerFindById(int answerId) {
		Session session=entityManager.unwrap(Session.class);
		
		Answer asnwer=session.get(Answer.class, answerId);
		return asnwer;
	}

	@Override
	@Transactional
	public void addAnswer(Answer answer) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(answer);
		
	}

	@Override
	@Transactional
	public void updateAnswer(Answer answer) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(answer);
		
	}

}
