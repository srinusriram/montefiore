package com.montefiore.incidents.config;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Validated
@ConfigurationProperties("incprop")
/**
 * This Class is to store the Incidents Config Properties
 */
public class IncidentsProperties {

	@NotBlank
	private String incidentsTrafficServiceUrl;

	@NotBlank
	private String locationSearchServiceUrl;

	@NotBlank
	private String locationAPIServiceUrl;

	@NotBlank
	private String locationAPIWeatherNode;

	/**
	 * Default Constructor
	 */
	public IncidentsProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the incidentsTrafficServiceUrl
	 */
	public String getIncidentsTrafficServiceUrl() {
		return incidentsTrafficServiceUrl;
	}

	/**
	 * @param incidentsTrafficServiceUrl
	 *            the incidentsTrafficServiceUrl to set
	 */
	public void setIncidentsTrafficServiceUrl(String incidentsTrafficServiceUrl) {
		this.incidentsTrafficServiceUrl = incidentsTrafficServiceUrl;
	}

	/**
	 * @return the locationSearchServiceUrl
	 */
	public String getLocationSearchServiceUrl() {
		return locationSearchServiceUrl;
	}

	/**
	 * @param locationSearchServiceUrl
	 *            the locationSearchServiceUrl to set
	 */
	public void setLocationSearchServiceUrl(String locationSearchServiceUrl) {
		this.locationSearchServiceUrl = locationSearchServiceUrl;
	}

	/**
	 * @return the locationAPIServiceUrl
	 */
	public String getLocationAPIServiceUrl() {
		return locationAPIServiceUrl;
	}

	/**
	 * @param locationAPIServiceUrl
	 *            the locationAPIServiceUrl to set
	 */
	public void setLocationAPIServiceUrl(String locationAPIServiceUrl) {
		this.locationAPIServiceUrl = locationAPIServiceUrl;
	}

	/**
	 * @return the locationAPIWeatherNode
	 */
	public String getLocationAPIWeatherNode() {
		return locationAPIWeatherNode;
	}

	/**
	 * @param locationAPIWeatherNode
	 *            the locationAPIWeatherNode to set
	 */
	public void setLocationAPIWeatherNode(String locationAPIWeatherNode) {
		this.locationAPIWeatherNode = locationAPIWeatherNode;
	}

	/*
	 * IncidentsProperties toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IncidentsProperties [incidentsTrafficServiceUrl=" + incidentsTrafficServiceUrl
				+ ", locationSearchServiceUrl="
				+ locationSearchServiceUrl + ", locationAPIServiceUrl=" + locationAPIServiceUrl
				+ ", locationAPIWeatherNode=" + locationAPIWeatherNode + "]";
	}

}
