package com.gsw.presentatie.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wagon {

	@Id
	@Column(name = "wagon_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public Wagon setId(final long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Wagon setName(final String name) {
		this.name = name;
		return this;
	}
	
}
