package com.montefiore.incidents.dto;

/**
 * This Class is mainly to store the Incidents BoundingBox Details
 */
public class IncidentsBoundingBox {

	private double incBBSLatitude;
	private double incBBNLatitude;
	private double incBBWLongitude;
	private double incBBELongitude;

	/**
	 * Default Constructor
	 */
	public IncidentsBoundingBox() {
		super();
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param incBBSLatitude
	 * @param incBBNLatitude
	 * @param incBBWLongitude
	 * @param incBBELogitude
	 */
	public IncidentsBoundingBox(double incBBSLatitude, double incBBNLatitude, double incBBWLongitude,
			double incBBELongitude) {
		super();
		this.incBBSLatitude = incBBSLatitude;
		this.incBBNLatitude = incBBNLatitude;
		this.incBBWLongitude = incBBWLongitude;
		this.incBBELongitude = incBBELongitude;
	}

	/**
	 * @return the incBBSLatitude
	 */
	public double getIncBBSLatitude() {
		return incBBSLatitude;
	}

	/**
	 * @param incBBSLatitude
	 *            the incBBSLatitude to set
	 */
	public void setIncBBSLatitude(double incBBSLatitude) {
		this.incBBSLatitude = incBBSLatitude;
	}

	/**
	 * @return the incBBNLatitude
	 */
	public double getIncBBNLatitude() {
		return incBBNLatitude;
	}

	/**
	 * @param incBBNLatitude
	 *            the incBBNLatitude to set
	 */
	public void setIncBBNLatitude(double incBBNLatitude) {
		this.incBBNLatitude = incBBNLatitude;
	}

	/**
	 * @return the incBBWLongitude
	 */
	public double getIncBBWLongitude() {
		return incBBWLongitude;
	}

	/**
	 * @param incBBWLongitude
	 *            the incBBWLongitude to set
	 */
	public void setIncBBWLongitude(double incBBWLongitude) {
		this.incBBWLongitude = incBBWLongitude;
	}

	/**
	 * @return the incBBELogitude
	 */
	public double getIncBBELongitude() {
		return incBBELongitude;
	}

	/**
	 * @param incBBELogitude
	 *            the incBBELogitude to set
	 */
	public void setIncBBELongitude(double incBBELongitude) {
		this.incBBELongitude = incBBELongitude;
	}

	/*
	 * IncidentsBoundingBox toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IncidentsBoundingBox [incBBSLatitude=" + incBBSLatitude + ", incBBNLatitude=" + incBBNLatitude
				+ ", incBBWLongitude=" + incBBWLongitude + ", incBBELongitude=" + incBBELongitude + "]";
	}

}
