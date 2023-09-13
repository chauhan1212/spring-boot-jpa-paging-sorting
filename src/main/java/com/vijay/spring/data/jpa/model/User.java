package com.vijay.spring.data.jpa.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

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
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	private String username;
	private Timestamp regDateTime;
	private BigDecimal userTimezone;
	private String userWebsite;
	
	@Lob 
	@Column(length=512)
	private String userPasswordHash;
	
	@Lob 
	@Column(length=512)
	private String userPasswordSalt;
	
	private String userIdOnChannel;
	
	private int userNoOfPosts;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable=true)
	private Channel channel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable=true)
	private MessageHistory messageHistory;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<Message> messages;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<UserIPAddress> userIPAddresses;
		
	@Lob
	@Column(name="link", length=512)
	private String link;
	
	@Column(name = "modified", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp modified;
	
	@Column(name = "created", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp created;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(Timestamp regDateTime) {
		this.regDateTime = regDateTime;
	}

	public BigDecimal getUserTimezone() {
		return userTimezone;
	}

	public void setUserTimezone(BigDecimal userTimezone) {
		this.userTimezone = userTimezone;
	}

	public String getUserWebsite() {
		return userWebsite;
	}

	public void setUserWebsite(String userWebsite) {
		this.userWebsite = userWebsite;
	}

	public String getUserPasswordHash() {
		return userPasswordHash;
	}

	public void setUserPasswordHash(String userPasswordHash) {
		this.userPasswordHash = userPasswordHash;
	}

	public String getUserPasswordSalt() {
		return userPasswordSalt;
	}

	public void setUserPasswordSalt(String userPasswordSalt) {
		this.userPasswordSalt = userPasswordSalt;
	}

	public String getUserIdOnChannel() {
		return userIdOnChannel;
	}

	public void setUserIdOnChannel(String userIdOnChannel) {
		this.userIdOnChannel = userIdOnChannel;
	}

	public int getUserNoOfPosts() {
		return userNoOfPosts;
	}

	public void setUserNoOfPosts(int userNoOfPosts) {
		this.userNoOfPosts = userNoOfPosts;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
	
}
