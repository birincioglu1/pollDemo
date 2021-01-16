package com.example.pollDemo.entity;

import java.util.Date;
import java.util.Set;


import javax.persistence.*;

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

	@OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserContact> contacts;


	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="location_id")
	private UserLocation userLocation;
	
	
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name="user_vote",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "vote_id"))
//	private List<Vote> votes=new ArrayList<Vote>();
	

	public User(User user) {
		
	}
	
	
	
	
}
