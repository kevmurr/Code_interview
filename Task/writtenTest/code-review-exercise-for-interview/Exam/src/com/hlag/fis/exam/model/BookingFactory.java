package com.hlag.fis.exam.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import com.hlag.fis.exam.service.BookingRepository;

@ApplicationScoped
public class BookingFactory {

	private BookingRepository repository;
	private CargoRepository cargoRepository;
	private ContainerRepository containerRepository;

	@Inject
	public BookingFactory(
			BookingRepository repository,
			CargoRepository cargoRepository,
			ContainerRepository containerRepository) {
		this.repository = repository;
		this.cargoRepository = cargoRepository;
		this.containerRepository = containerRepository;
	}

	@Valid
	public Booking createBooking(ArrayList<Cargo> cargos, ArrayList<Container> containers) {
		Booking booking = new Booking(cargoRepository, 1, 1, cargos, containers);
		repository.persist(booking);
		return booking;
	}

	public Booking createBooking(List<Integer> cargosIds, List<Integer> containerIds) {
		Booking booking = new Booking(cargoRepository, 1, 1);
		for (int i = 0; i < cargosIds.size() - 1; i++) {
			booking.addCargo(cargosIds.get(i));
		}
		for (int i = 0; i < containerIds.size() - 1; i++) {
			booking.addCargo(containerIds.get(i));
		}
		repository.persist(booking);
		return booking;
	}

	public ContainerRepository getContainerRepository() {
		return containerRepository;
	}

}
