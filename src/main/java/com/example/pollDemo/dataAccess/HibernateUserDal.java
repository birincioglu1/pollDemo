package com.example.pollDemo.dataAccess;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.pollDemo.entity.Answer;
import com.example.pollDemo.entity.Category;
import com.example.pollDemo.entity.Poll;
import com.example.pollDemo.entity.Role;
import com.example.pollDemo.entity.User;
import com.example.pollDemo.entity.Vote;
import com.example.pollDemo.model.UserInfo;

@Repository
public class HibernateUserDal implements IUserDal {

	private EntityManager entityManager;
	
	@Autowired
	public HibernateUserDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<User> getAll() {
		Session session=entityManager.unwrap(Session.class);
		List<User> users=session.createQuery("from User",User.class).getResultList();

		return users;
	}

	@Override
	@Transactional
	public void add(User user) {
		Session session=entityManager.unwrap(Session.class);

		session.saveOrUpdate(user);


	}

	@Override
	@Transactional
	public void delete(long userId) {
		Session session=entityManager.unwrap(Session.class);
		User userDelete=session.get(User.class, userId);
		session.delete(userDelete);
		
	}

	@Override
	@Transactional
	public void update(User user) {
		Session session=entityManager.unwrap(Session.class);
		
		
		
		
		session.update(user);
		
	}

	@Override
	@Transactional
	public User userFindById(long userId) {
		Session session=entityManager.unwrap(Session.class);
		
		User user=session.get(User.class, userId);
		
		return user;
	}

	@Override
	@Transactional
	public void addCustom() {
		
		
//		
//		
//		Session session=entityManager.unwrap(Session.class);
//		
//		
//		User user=new User();
//		Role role=new Role();
//		role.setRole("ADMIN");
//		Set<Role> roles = Stream.of(role)
//                .collect(Collectors.toCollection(HashSet::new));
//		user.setRoles(roles);
//		
//		user.setAddress("İstanbul");
//		user.setName("hasan");
//		user.setIntro("hello ");
//		user.setLastLogin(new Date());
//		user.setUsername("hasan2");
//		user.setPassword("12345");
//		user.setSurname("aydın");
//	
//		Poll poll=new Poll();
//		Vote vote =new Vote();
//		Answer answer=new Answer();
//		Category category=new Category();
//		
//		category.setTitle("Spor");
//		category.setPoll(poll);
//		answer.setContent("A");
//		answer.setCount(1);
//		answer.setPoll(poll);
//		vote.setPoll(poll);
//		vote.setAnswer(answer);
//		vote.setUserId(user.getUserId());
//		
//		answer.addVote(vote);
//		
//		poll.addAnswer(answer);
//		poll.addVote(vote);
//		poll.addCategory(category);
//		poll.setTitle("adem adam mı?");
//		user.setStatus(1);
//		
//		
//		session.save(category);
//		session.save(answer);
//		session.save(poll);
//		session.save(vote);
//		session.save(user);
		
		
	}

	@Override
	@Transactional
	public UserInfo findUserInfoById(long userId) {
		Session session=entityManager.unwrap(Session.class);
		UserInfo user=session.createNamedQuery("User.findUserInfoById",UserInfo.class).setParameter("userId", userId).getSingleResult();
				
		return user;
		
		
	}
	
	



}
