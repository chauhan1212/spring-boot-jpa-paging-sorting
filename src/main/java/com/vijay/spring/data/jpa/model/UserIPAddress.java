package com.vijay.spring.data.jpa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserIPAddress")
public class UserIPAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String ipAddress;
	
	private int ipAddressUseDateTime;
	
	private String ipAddressProvider;
	
	private String ipAddressCountry;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(nullable=true)
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getIpAddressUseDateTime() {
		return ipAddressUseDateTime;
	}

	public void setIpAddressUseDateTime(int ipAddressUseDateTime) {
		this.ipAddressUseDateTime = ipAddressUseDateTime;
	}

	public String getIpAddressProvider() {
		return ipAddressProvider;
	}

	public void setIpAddressProvider(String ipAddressProvider) {
		this.ipAddressProvider = ipAddressProvider;
	}

	public String getIpAddressCountry() {
		return ipAddressCountry;
	}

	public void setIpAddressCountry(String ipAddressCountry) {
		this.ipAddressCountry = ipAddressCountry;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
