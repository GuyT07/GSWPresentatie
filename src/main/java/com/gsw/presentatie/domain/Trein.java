package com.gsw.presentatie.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Trein {

	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name = "trein_x_wagon",
			joinColumns = @JoinColumn(name = "trein_id"),
			inverseJoinColumns = @JoinColumn(name = "wagon_id")
	)
	private List<Wagon> wagons;
	
	@Id
	@Column(name = "train_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String merk;

	public long getId() {
		return id;
	}

	public Trein setId(final long id) {
		this.id = id;
		return this;
	}

	public String getMerk() {
		return merk;
	}

	public Trein setMerk(final String merk) {
		this.merk = merk;
		return this;
	}
	
	public List<Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(final List<Wagon> wagons) {
		this.wagons = wagons;
	}
}
