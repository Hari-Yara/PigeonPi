package com.pigeonpi.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@Column(name = "userid")
	private String userId;
	@Column(name = "username")
	private String username;
	@Column(name = "local_name")
	private String localName;
	@Column(name = "latch")
	private int latch;
	@Column(name = "dialing_code")
	private int dialingCode;
	@Column(name = "mobile_number")
	private Long mobileNumber;
	@Column(name = "dp_url")
	private String dpUrl;
	@Column(name = "registration_token")
	private String registrationToken;
	@Column(name = "online_status")
	private LocalDateTime onlineStatus;
	@Column(name = "bio")
	private String bio;

	public User() {
		super();
	}

	public User(String userId, String username, String localName, int latch, int dialingCode, Long mobileNumber,
			String dpUrl, String registrationToken, LocalDateTime onlineStatus, String bio) {
		super();
		this.userId = userId;
		this.username = username;
		this.localName = localName;
		this.latch = latch;
		this.dialingCode = dialingCode;
		this.mobileNumber = mobileNumber;
		this.dpUrl = dpUrl;
		this.registrationToken = registrationToken;
		this.onlineStatus = onlineStatus;
		this.bio = bio;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public int getLatch() {
		return latch;
	}

	public void setLatch(int latch) {
		this.latch = latch;
	}

	public int getDialingCode() {
		return dialingCode;
	}

	public void setDialingCode(int dialingCode) {
		this.dialingCode = dialingCode;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDpUrl() {
		return dpUrl;
	}

	public void setDpUrl(String dpUrl) {
		this.dpUrl = dpUrl;
	}

	public String getRegistrationToken() {
		return registrationToken;
	}

	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}

	public LocalDateTime getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(LocalDateTime onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", localName=" + localName + ", latch=" + latch
				+ ", dialingCode=" + dialingCode + ", mobileNumber=" + mobileNumber + ", dpUrl=" + dpUrl
				+ ", registrationToken=" + registrationToken + ", onlineStatus=" + onlineStatus + ", bio=" + bio + "]";
	}

	

}
