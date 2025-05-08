package br.com.ifspcjo.ads.web2;

import java.time.LocalDate;

public class Task 
{
	private int id;
	private String description;
	private LocalDate date;
	
	public Task(int id, String description, LocalDate date)
	{
		this.id = id;
		this.description = description;
		this.date = date;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}
}
