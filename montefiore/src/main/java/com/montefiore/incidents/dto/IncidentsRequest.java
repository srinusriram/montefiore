package com.montefiore.incidents.dto;

/**
 * This Class is mainly to store the Incidents Requests Details
 */
public class IncidentsRequest {

	private int incType;
	private int incSeverity;
	private int incLimit;
	private IncidentsBoundingBox incBb;
	
	/**
	 * Default Constructor
	 */
	public IncidentsRequest() {
		super();
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param inc_Type
	 * @param inc_Severity
	 * @param inc_bb
	 */
	public IncidentsRequest(int incType, int incSeverity, int incLimit, IncidentsBoundingBox incBb) {
		super();
		this.incType = incType;
		this.incSeverity = incSeverity;
		this.incLimit = incLimit;
		this.incBb = incBb;
	}

	/**
	 * @return the incType
	 */
	public int getIncType() {
		return incType;
	}

	/**
	 * @param incType
	 *            the incType to set
	 */
	public void setIncType(int incType) {
		this.incType = incType;
	}

	/**
	 * @return the incSeverity
	 */
	public int getIncSeverity() {
		return incSeverity;
	}

	/**
	 * @param incSeverity
	 *            the incSeverity to set
	 */
	public void setIncSeverity(int incSeverity) {
		this.incSeverity = incSeverity;
	}

	/**
	 * @return the incLimit
	 */
	public int getIncLimit() {
		return incLimit;
	}

	/**
	 * @param incLimit
	 *            the incLimit to set
	 */
	public void setIncLimit(int incLimit) {
		this.incLimit = incLimit;
	}

	/**
	 * @return the incBb
	 */
	public IncidentsBoundingBox getIncBb() {
		return incBb;
	}

	/**
	 * @param incBb
	 *            the incBb to set
	 */
	public void setIncBb(IncidentsBoundingBox incBb) {
		this.incBb = incBb;
	}

	/*
	 * IncidentsRequest toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IncidentsRequest [incType=" + incType + ", incSeverity=" + incSeverity + ", incLimit=" + incLimit
				+ ", incBb=" + incBb + "]";
	}

}
