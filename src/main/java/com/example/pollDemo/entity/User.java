package com.example.pollDemo.entity;

import java.util.Date;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.Lob;

import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name="User.findUserInfoById",query ="SELECT new com.example.pollDemo.model.UserInfo(u.userId,u.name,u.surname,u.intro,u.username,u.photo)"
			+ "FROM User u WHERE u.userId = :userId" )
})
public class User extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	
	private int status;
	
	@ManyToOne()
    @JoinColumn(name = "user_role")
    private Role role;
	
	private String name;
	private String surname;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	
	@Lob
	private String intro;
	private String photo;
	
	@Column(name="username",length=20,updatable=true,nullable=true,unique=true)
	private String username;
	
	private String password;
	private String gender;
	private int age;
	private String education;
	private String job;
	private String phone;
	private String email;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="address_id")
	private Address address;
	
	
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name="user_vote",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "vote_id"))
//	private List<Vote> votes=new ArrayList<Vote>();
	

	public User(User user) {
		
	}
	
	
	
	
}
