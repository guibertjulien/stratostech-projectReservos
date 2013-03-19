package com.stratostech.reservos.server;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
	/*
	 * persistence-unit name="projetReservosJPA" in persistence.xml
	 */
	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("projetReservosJPA");

	private EMF() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}