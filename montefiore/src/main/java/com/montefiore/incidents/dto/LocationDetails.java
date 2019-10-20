package com.montefiore.incidents.dto;

/**
 * This Class is mainly to store the Incidents Location Details
 */
public class LocationDetails {

	private int distance;
	private String title;
	private String location_type;
	private int woeid;
	private String latt_long;

	/**
	 * Default Constructor
	 */
	public LocationDetails() {
		super();
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the location_type
	 */
	public String getLocation_type() {
		return location_type;
	}

	/**
	 * @param location_type
	 *            the location_type to set
	 */
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	/**
	 * @return the woeid
	 */
	public int getWoeid() {
		return woeid;
	}

	/**
	 * @param woeid
	 *            the woeid to set
	 */
	public void setWoeid(int woeid) {
		this.woeid = woeid;
	}

	/**
	 * @return the latt_long
	 */
	public String getLatt_long() {
		return latt_long;
	}

	/**
	 * @param latt_long
	 *            the latt_long to set
	 */
	public void setLatt_long(String latt_long) {
		this.latt_long = latt_long;
	}

	/*
	 * LocationDetails toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LocationDetails [distance=" + distance + ", title=" + title + ", location_type=" + location_type
				+ ", woeid=" + woeid + ", latt_long=" + latt_long + "]";
	}

}
