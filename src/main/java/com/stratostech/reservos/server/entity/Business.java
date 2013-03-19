package com.stratostech.reservos.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class or POJO representing a Contact
 * 
 * @author Julien
 * 
 */
@Entity
public class Business {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessID;
	private String businessName;

	public Business() {

	}

	public Business(Long businessID, String businessName) {
		this.businessID = businessID;
		this.businessName = businessName;
	}

	/**
	 * @return the businessID
	 */
	public Long getBusinessID() {
		return businessID;
	}

	/**
	 * @param businessID
	 *            the businessID to set
	 */
	public void setBusinessID(Long businessID) {
		this.businessID = businessID;
	}

	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * @param businessName
	 *            the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

}
