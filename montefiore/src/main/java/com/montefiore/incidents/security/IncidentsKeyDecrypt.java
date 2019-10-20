package com.montefiore.incidents.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
/*
 * This Class is to encrypt Service Key of Traffic Incidents
 */
public class IncidentsKeyDecrypt {

	@Value("${incidents-service-encryptkey}")
	private String serviceKey;

	/**
	 * Default Constructor
	 */
	public IncidentsKeyDecrypt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the serviceKey
	 */
	public String getServiceKey() {
		return serviceKey;
	}

	/*
	 * IncidentKeyDecrypt toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IncidentKeyDecrypt [serviceKey=" + serviceKey + "]";
	}

}
