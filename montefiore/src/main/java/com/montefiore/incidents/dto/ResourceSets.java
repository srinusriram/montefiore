package com.montefiore.incidents.dto;

import java.util.List;

/**
 * This Class is mainly to store the Incidents ResourceSet Details
 */
public class ResourceSets {
	private int estimatedTotal;
	private List<Resources> resources;

	/**
	 * Default Constructor
	 */
	public ResourceSets() {
		super();
	}

	/**
	 * @return the estimatedTotal
	 */
	public int getEstimatedTotal() {
		return estimatedTotal;
	}

	/**
	 * @param estimatedTotal
	 *            the estimatedTotal to set
	 */
	public void setEstimatedTotal(int estimatedTotal) {
		this.estimatedTotal = estimatedTotal;
	}

	/**
	 * @return the resources
	 */
	public List<Resources> getResources() {
		return resources;
	}

	/**
	 * @param resources
	 *            the resources to set
	 */
	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}

	/*
	 * ResourceSets toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResourceSets [estimatedTotal=" + estimatedTotal + ", resources=" + resources + "]";
	}

}
