package com.gsw.presentatie.domain;

import java.util.List;

import javax.persistence.CascadeType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long trein_id;
	
	private String merk;

	public long getTrein_id() {
		return trein_id;
	}

	public Trein setTrein_id(long id) {
		this.trein_id = id;
		return this;
	}

	public String getMerk() {
		return merk;
	}

	public Trein setMerk(String merk) {
		this.merk = merk;
		return this;
	}
	
	public List<Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(List<Wagon> wagons) {
		this.wagons = wagons;
	}
}
