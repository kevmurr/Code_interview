package com.hlag.fis.exam.rest.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Booking creation composite
 */
public class BookingCreationComposite {

	@NotNull
	@Size(min = 1)
	private List<Integer> containerIds;

	@NotNull
	@Size(min = 1)
	private List<Integer> cargoIds;

	public BookingCreationComposite(List<Integer> containerIds, List<Integer> cargoIds) {
		this.containerIds = containerIds;
		this.cargoIds = cargoIds;
	}

	/**
	 * setter for cargo ids
	 */
	public void setCargoIds(List<Integer> cargoIds) {
		this.cargoIds = cargoIds;
	}

	/**
	 * setter for container ids
	 */
	public void setContainerIds(List<Integer> containerIds) {
		this.containerIds = containerIds;
	}

	/**
	 * getter for container ids
	 */
	public List<Integer> getContainerIds() {
		return containerIds;
	}

	/**
	 * getter for cargo ids
	 */
	public List<Integer> getCargoIds() {
		return cargoIds;
	}

}
