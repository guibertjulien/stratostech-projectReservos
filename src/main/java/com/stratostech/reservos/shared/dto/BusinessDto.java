package com.stratostech.reservos.shared.dto;

import java.io.Serializable;

public class BusinessDto implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private Long businessID;
	private String businessName;

	public BusinessDto() {

	}

	public BusinessDto(Long businessID, String businessName) {
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
