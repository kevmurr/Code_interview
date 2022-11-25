package com.hlag.fis.exam.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CARGO")
@Access(AccessType.FIELD)
public class Cargo {

	@javax.persistence.Version
	@Column(name = "VERSION")
	private Integer version;

	@Column(name = "ID")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOKING_ID", referencedColumnName = "ID")
	private Booking booking;

	@Column(name = "WEIGHT")
	private Integer weight;

	protected Cargo() {
		// default constructor
	}

	Cargo(Integer version, Integer id, Booking booking, Integer weight) {
		this.version = version;
		this.id = id;
		this.booking = booking;
		this.weight = weight;
	}

	public Integer getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}

	public Booking getBooking() {
		return booking;
	}

	public Integer getWeight() {
		return weight;
	}
}
