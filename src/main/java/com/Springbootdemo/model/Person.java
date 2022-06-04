package com.Springbootdemo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	private final UUID id;
	private final String fname;
	private final String lname;
	
	public Person(@JsonProperty("id") UUID id, @JsonProperty("fname") String fname, @JsonProperty("lname") String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public UUID getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}
	
	

}
