package com.hlag.fis.exam.model;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Dependent
public class ContainerRepository {

	@Inject
	private EntityManager em;

	public Container findById(Integer id) {
		return em.find(Container.class, id);
	}

}
