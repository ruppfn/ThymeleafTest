package com.example.handlingformsubmission;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting{

	@Id
	@NotNull
	@Min(1)
	private int id;
	
	@NotNull
	@Size(min=3, max=50)
	private String content;
	
	public Greeting(int id, String content){
		this.id = id;
		this.content = content;
	}
	
	public Greeting(){}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	@Override
	public String toString(){
		return "ID: " + id + "\n\tContent: " + content;
	}
	
}