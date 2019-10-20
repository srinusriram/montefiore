package com.montefiore.incidents.dto;

import java.util.List;

/**
 * This Class is mainly to store the Incidents Response Details
 */
public class IncidentsResponse {
	private String authenticationResultCode;
	private String brandLogoUri;
	private String copyright;
	private int statusCode;
	private String statusDescription;
	private String traceId;
	private List<ResourceSets> resourceSets;

	/**
	 * Default Constructor
	 */
	public IncidentsResponse() {
		super();
	}

	/**
	 * @return the authenticationResultCode
	 */
	public String getAuthenticationResultCode() {
		return authenticationResultCode;
	}

	/**
	 * @param authenticationResultCode
	 *            the authenticationResultCode to set
	 */
	public void setAuthenticationResultCode(String authenticationResultCode) {
		this.authenticationResultCode = authenticationResultCode;
	}

	/**
	 * @return the brandLogoUri
	 */
	public String getBrandLogoUri() {
		return brandLogoUri;
	}

	/**
	 * @param brandLogoUri
	 *            the brandLogoUri to set
	 */
	public void setBrandLogoUri(String brandLogoUri) {
		this.brandLogoUri = brandLogoUri;
	}

	/**
	 * @return the copyright
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * @param copyright
	 *            the copyright to set
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusDescription
	 */
	public String getStatusDescription() {
		return statusDescription;
	}

	/**
	 * @param statusDescription
	 *            the statusDescription to set
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	/**
	 * @return the traceId
	 */
	public String getTraceId() {
		return traceId;
	}

	/**
	 * @param traceId
	 *            the traceId to set
	 */
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	/**
	 * @return the resourceSets
	 */
	public List<ResourceSets> getResourceSets() {
		return resourceSets;
	}

	/**
	 * @param resourceSets
	 *            the resourceSets to set
	 */
	public void setResourceSets(List<ResourceSets> resourceSets) {
		this.resourceSets = resourceSets;
	}

	/*
	 * IncidentsResponse toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IncidentsResponse [authenticationResultCode=" + authenticationResultCode + ", brandLogoUri="
				+ brandLogoUri + ", copyright=" + copyright + ", statusCode=" + statusCode + ", statusDescription="
				+ statusDescription + ", traceId=" + traceId + ", resourceSets=" + resourceSets + "]";
	}

}
