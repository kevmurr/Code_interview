package com.hlag.fis.exam.model;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Dependent
public class CargoRepository {

	@Inject
	private EntityManager em;

	public Cargo findById(Integer cargoId) {
		return em.find(Cargo.class, cargoId);
	}

}
