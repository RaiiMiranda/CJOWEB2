package br.edu.ifspcjo.ads.web2.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String description;
	private LocalDate date;
	private User user;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
