package com.example.pollDemo.notification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.pollDemo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "email_notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailNotification extends Notification{

	
	 @Column(name = "email_address",nullable = false )
		    private String emailAddress;
		 
}
