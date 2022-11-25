package com.hlag.fis.exam.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Access(AccessType.FIELD)
@Table(name = "CONTAINER")
public class Container {

	public static final String table = "CONTAINER";

	@javax.persistence.Version
	@Column(name = "VERSION")
	private Integer version;

	@EmbeddedId
	@Column(name = "ID")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOKING_ID", referencedColumnName = "ID")
	private Booking booking;

	@Column(name = "TYPE")
	private String type;

	protected Container() {
		// default constructor
	}

	Container(Integer version, Integer id, Booking booking, String type) {
		this.version = version;
		this.id = id;
		this.booking = booking;
		this.type = type;
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

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("table", table)
				.add("version", version)
				.add("id", id)
				.add("booking", booking)
				.add("type", type)
				.toString();
	}

}
