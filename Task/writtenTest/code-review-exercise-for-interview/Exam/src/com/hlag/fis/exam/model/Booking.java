package com.hlag.fis.exam.model;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = Booking.TABLE)
@Access(AccessType.FIELD)
public class Booking {

	public static final String TABLE = "BOOKING";

	@Inject
	@Transient
	private CargoRepository cargoRepository;

	@Inject
	@Transient
	private ContainerRepository containerRepository;

	@Version
	@Column(name = "VERSION")
	private Integer version;

	@Column(name = "ID")
	private Integer id;

	@OneToMany(mappedBy = "booking", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ArrayList<Cargo> cargos;

	@OneToMany(mappedBy = "booking", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ArrayList<Container> containers;

	@Column(name = "STATE")
	private String state;

	protected Booking() {
		// default constructor
	}

	Booking(
			CargoRepository cargoRepository,
			Integer version,
			Integer id,
			ArrayList<Cargo> cargos,
			ArrayList<Container> containers) {
		this.cargoRepository = cargoRepository;
		this.version = version;
		this.id = id;
		this.cargos = cargos;
		this.containers = containers;
		this.state = "INIT";
	}

	Booking(CargoRepository cargoRepository, Integer version, Integer id) {
		this.cargoRepository = cargoRepository;
		this.version = version;
		this.id = id;
		this.cargos = new ArrayList<>();
		this.containers = new ArrayList<>();
		this.state = "INIT";
	}

	public Integer getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}

	public ArrayList<Cargo> getCargos() {
		return cargos;
	}

	public String getState() {
		return state;
	}

	public ArrayList<Container> getContainers() {
		return containers;
	}

	public void addCargo(Integer cargoId) {
		cargos.add(this.cargoRepository.findById(cargoId));
	}

	public void addContainer(Integer containerId) {
		cargos.add(this.cargoRepository.findById(containerId));
	}

}
