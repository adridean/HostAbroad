package com.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@Id
	private String nickname;
	private double rating;
	private String description;
	private boolean host;
	
	public User() {};
	
	public User(String nickname, double rating, String description, boolean host){
		this.nickname = nickname;
		this.rating = rating;
		this.description = description;
		this.host = host;
	}
	
	public User(String nickname, double rating, String description){
		this.nickname = nickname;
		this.rating = rating;
		this.description = description;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getNickName() {
		return this.nickname;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public double getRating() {
		return this.rating;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setHost(boolean host) {
		this.host = host;
	}
	
	public boolean getHost() {
		return this.host;
	}
}
