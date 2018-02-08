package com.gsw.presentatie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wagon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long wagon_id;
	
	private String name;

	public long getWagon_id() {
		return wagon_id;
	}

	public Wagon setWagon_id(long id) {
		this.wagon_id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Wagon setName(String name) {
		this.name = name;
		return this;
	}
	
}
