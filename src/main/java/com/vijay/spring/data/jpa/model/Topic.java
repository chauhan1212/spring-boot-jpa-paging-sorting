package com.vijay.spring.data.jpa.model;

import java.sql.Date;
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
@Table(name = "topic")
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Lob 
	@Column(length=512)
	private String title;
	
	@Lob 
	@Column( length=512)
	private String translatedTitle;
	
	@Lob 
	@Column(length=512)
	private String summary;
	
	@Lob 
	@Column(name="link", length=512)
	private String link;
	
	private long firstPostId;
	
	private Timestamp firstPostTime;
	
	private long lastPostId;
	
	private Timestamp lastPostTime;
	
	private String language;
	
	private byte isRelevant;
	
	private Date lastSuccessfulPostDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable=false)
	private Channel channel;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(nullable=true)
	private SubChannel subChannel;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<Message> messages;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<MessageHistory> messageHistories;
	
	@Column(name = "lastUpdated", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp lastUpdated;
	
	private byte ignored;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTranslatedTitle() {
		return translatedTitle;
	}

	public void setTranslatedTitle(String translatedTitle) {
		this.translatedTitle = translatedTitle;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public long getFirstPostId() {
		return firstPostId;
	}

	public void setFirstPostId(long firstPostId) {
		this.firstPostId = firstPostId;
	}

	public Timestamp getFirstPostTime() {
		return firstPostTime;
	}

	public void setFirstPostTime(Timestamp firstPostTime) {
		this.firstPostTime = firstPostTime;
	}

	public long getLastPostId() {
		return lastPostId;
	}

	public void setLastPostId(long lastPostId) {
		this.lastPostId = lastPostId;
	}

	public Timestamp getLastPostTime() {
		return lastPostTime;
	}

	public void setLastPostTime(Timestamp lastPostTime) {
		this.lastPostTime = lastPostTime;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public byte getIsRelevant() {
		return isRelevant;
	}

	public void setIsRelevant(byte isRelevant) {
		this.isRelevant = isRelevant;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Date getLastSuccessfulPostDate() {
		return lastSuccessfulPostDate;
	}

	public void setLastSuccessfulPostDate(Date lastSuccessfulPostDate) {
		this.lastSuccessfulPostDate = lastSuccessfulPostDate;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public SubChannel getSubChannel() {
		return subChannel;
	}

	public void setSubChannel(SubChannel subChannel) {
		this.subChannel = subChannel;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public byte getIgnored() {
		return ignored;
	}

	public void setIgnored(byte ignored) {
		this.ignored = ignored;
	}
	
}
