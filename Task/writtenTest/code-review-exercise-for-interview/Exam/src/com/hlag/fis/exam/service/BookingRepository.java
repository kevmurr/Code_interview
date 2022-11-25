package com.hlag.fis.exam.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.hlag.fis.exam.model.Booking;

@Dependent
public class BookingRepository {

	@Inject
	private EntityManager entityManager;

	public Optional<Booking> selectById(Integer bookingId) {
		Optional<Booking> o = Optional.ofNullable(entityManager.find(Booking.class, bookingId));
		return o;
	}

	public TypedQuery<Booking> query(String qlString) {
		return entityManager.createQuery(qlString, Booking.class);
	}

	public void persist(Booking entity) {
		entityManager.persist(entity);
	}

	public void delete(Integer id) {
		entityManager.remove(id);
	}

	public List<Booking> selectByState(String string) {
		TypedQuery<Booking> query = query("select b from Booking b where b.state = :state");
		query.setParameter("state", string);
		return query.getResultList();
	}

}
