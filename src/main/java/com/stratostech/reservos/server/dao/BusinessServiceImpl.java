package com.stratostech.reservos.server.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.stratostech.reservos.client.BusinessService;
import com.stratostech.reservos.server.EMF;
import com.stratostech.reservos.server.entity.Business;
import com.stratostech.reservos.shared.dto.BusinessDto;

/**
 * Service class for CRUD operations on Business bean
 * 
 * @author Julien
 * 
 */
public class BusinessServiceImpl extends RemoteServiceServlet implements BusinessService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BusinessServiceImpl.class.getName());

	/**
	 * Creates a Business - with persistence
	 * 
	 * @param c
	 */
	public void createBusiness(BusinessDto businessDto) {
		logger.info("Entering createBusiness: [" + businessDto.getBusinessName() + "]");
		EntityManager mgr = EMF.get().createEntityManager();

		Business business = new Business();
		business.setBusinessName(businessDto.getBusinessName());

		try {
			mgr.getTransaction().begin();
			mgr.persist(business);
			mgr.getTransaction().commit();
		} finally {
			mgr.close();
		}
		logger.info("Exiting createBusiness");
	}

	/**
	 * Gets a Business given an ID
	 * 
	 * @param id
	 * @return Business bean
	 */
	public BusinessDto getBusiness(Long id) {
		logger.info("Entering getBusiness[" + id + "]");
		BusinessDto result = null;
		EntityManager mgr = EMF.get().createEntityManager();
		try {
			Business business = mgr.find(Business.class, id);

			result = new BusinessDto(business.getBusinessID(), business.getBusinessName());

		} finally {
			mgr.close();
		}
		if (result == null) {
			logger.warning("No Businesss returned");
		}
		logger.info("Exiting getBusiness");

		return result;
	}

	/**
	 * Gets all Businesss
	 * 
	 * @return List of Business beans
	 */
	public List getAllBusiness() {
		logger.info("Entering getAllBusiness");
		List result = null;
		EntityManager mgr = EMF.get().createEntityManager();
		try {
			Query q = mgr.createQuery("SELECT x from Business x");
			result = (List) q.getResultList();
			for (Object a : result) {
				if (a instanceof Business) {
					System.out.println(((Business) a).getBusinessName());
				}
			}
		} finally {
			mgr.close();
		}
		if (result == null) {
			logger.warning("No Businesss returned");
		}
		logger.info("Exiting getAllBusiness");
		return result;
	}

	/**
	 * Deletes all Businesss
	 */
	public void deleteAllBusiness() {
		logger.info("Entering deleteAllBusiness");
		EntityManager mgr = EMF.get().createEntityManager();
		try {
			Query q = mgr.createQuery("DELETE FROM Business x");
			q.executeUpdate();
		} finally {
			mgr.close();
		}
		logger.info("Exiting deleteAllBusiness");
	}
}
