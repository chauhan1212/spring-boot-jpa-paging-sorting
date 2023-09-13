package com.vijay.spring.data.jpa.model;

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
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int postVersion;	
	
	private Timestamp messageDateTime;
	
	@Lob 
	@Column(length=512)
	private String messageTitle;
	
	@Lob 
	@Column(length=512)
	private String messageTitleAutoTranslation;
	
	@Lob 
	@Column(length=512)
	private String messageTitleManualTranslation;
	
	@Lob 
	@Column(length=512)
	private String messageContent;
	
	@Lob 
	@Column(length=512)
	private String messageContentRaw;
	
	@Lob 
	@Column(length=512)	
	private String messageContentAutoTranslation;
	
	@Lob 
	@Column(length=512)
	private String messageContentManualTranslation;
	
	private byte processed;
	
	private String translationStatus;
	
	private String translationStatusCommentary;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<UserIPAddress> userIPAddresses;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable=false)
	private Topic topic;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable=true)
	private User user;
	
	@Column(name = "modified", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp modified;
	
	
	
}
