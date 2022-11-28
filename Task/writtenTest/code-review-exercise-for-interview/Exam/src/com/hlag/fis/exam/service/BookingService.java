package com.hlag.fis.exam.service;

import java.util.Objects;
import java.util.Optional;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.hlag.fis.exam.model.Booking;
import com.hlag.fis.exam.model.BookingFactory;

@Dependent
public class BookingService {

	private BookingFactory factory;
	private BookingRepository repository;

	public BookingService() {
		// default
	}

	@Inject
	public BookingService(BookingFactory factory, BookingRepository repository) {
		this.factory = factory;
		this.repository = repository;
	}

	public Optional<Booking> findById(Integer id) {
		return repository.selectById(id);
	}

	public void deleteById(Integer id) {
		repository.delete(id);
	}

	public Booking updateStatusToAccepted(Integer id, String state, Integer version) {
		Booking booking = repository.selectByIdAndState(id, state);

    if (booking != null) {
      if (!Objects.equals(booking.getVersion(), version)) {
        throw new OptimisticLockingException("incorrect version");
      }

      return repository.updateState(id, state, version);
		}

		throw new IllegalStateException(String.format("Booking with ID %d, state %s, version %d does not exist", id, state, version));
	}

	public BookingFactory getFactory() {
		return factory;
	}

}
