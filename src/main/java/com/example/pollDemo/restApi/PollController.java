package com.example.pollDemo.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pollDemo.business.IPollService;
import com.example.pollDemo.entity.Poll;

import com.example.pollDemo.model.CustomPollVote;


@RequestMapping("/rest/poll")
@RestController
public class PollController {
	
	
	private IPollService pollService;

	@Autowired
	public PollController(IPollService pollService) {
		
		this.pollService = pollService;
	}
	
	
	@GetMapping("/all")
	public List<Poll> hello()
	{
		return pollService.getAll();
	}
	
	@PostMapping("/delete/{pollId}")
	public  void deletePoll(@PathVariable int pollId)
	{
		pollService.deletePoll(pollId);
		 
	}
	@PostMapping("/update")
	public  void updatePoll(@RequestBody Poll poll)
	{
		pollService.updatePoll(poll);
		 
	}
	@PostMapping("/add")
	public  void addPoll(@RequestBody Poll poll)
	{
		pollService.addPoll(poll);
		 
	}
	@PostMapping("/vote")
	public  void addVote(@RequestBody CustomPollVote customVote)
	{
		pollService.addVote(customVote);
		 
	}

}
