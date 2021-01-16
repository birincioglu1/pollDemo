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
@Table(name = "sms_notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmsNotification extends Notification {

	
	@Column(name = "phone_number",nullable = false)
	    private String phoneNumber;
}
