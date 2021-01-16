package com.example.pollDemo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
@Table(name = "poll")

//@NamedQueries({
//	@NamedQuery(name="Vote.getPollAll",query ="SELECT new com.example.pollDemo.model.CustomPoll(p.id,p.hostId,p.active,p.hostName,p.startAt,p.endAt,p.showAt,"
//			+ "p.photo,p.title,p.count,"
//			+ "new com.example.pollDemo.model.CustomCategory(c.id,c.title),"
//			+ "new com.example.pollDemo.model.CustomAnswer(a.id,a.content,p.count),"
//			+ "new com.example.pollDemo.model.CustomVote(v.id,v.userId) from Poll p LEFT JOIN FETCH p.categories c LEFT JOIN FETCH p.answers a LEFT JOIN FETCH p.votes v ")
//		
//})
public class Poll extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poll_id")
	private int id;
	
	
	private int hostId;
	private boolean active;
	
	@Column(name="host_name")
	private String hostName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date showAt;
	
	@Lob
	private String photo;
	@Lob
	private String title;
	private int count;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "poll",fetch = FetchType.LAZY)
	private Set<Category> categories;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "poll",fetch = FetchType.LAZY)
	private Set<Answer> answers;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="poll" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Location> location;
	
	
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "poll",fetch = FetchType.LAZY)
//
//	private Set<Vote> votes;

	
	public void addCategory(Category category)
	{
		this.categories.add(category);
		
	}
	public void addAnswer(Answer answer)
	{
		this.answers.add(answer);
	}
	
	public void addLocation(Location location)
	{
		this.location.add(location);
	}
	
//	public void addVote(Vote vote)
//	{
//		this.votes.add(vote);
//	}

}
