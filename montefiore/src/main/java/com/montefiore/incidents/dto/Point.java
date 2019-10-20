package com.montefiore.incidents.dto;

import java.util.Arrays;

/**
 * This Class is mainly to store the Incidents Location Points Details
 */
public class Point {

	private String type;
	private double[] coordinates;

	/**
	 * Default Constructor
	 */
	public Point() {
		super();
	}

	/**
	 * @param type
	 * @param coordinates
	 */
	public Point(String type, double[] coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the coordinates
	 */
	public double[] getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}

	/*
	 * Resources toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Point [type=" + type + ", coordinates=" + Arrays.toString(coordinates) + "]";
	}

}
