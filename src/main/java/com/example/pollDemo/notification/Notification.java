package com.example.pollDemo.notification;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.example.pollDemo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notification")
@Inheritance(
    strategy = InheritanceType.JOINED
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notification_id")
	private long notificationId;
	
	//private User user;
	private long senderId;
	private String url;
	private String text;
	private boolean isRead;

    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    @Column(name = "created_on")
    private Date createdOn;	
	
}
