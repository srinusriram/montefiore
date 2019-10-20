package com.montefiore.incidents.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is mainly to capture the Service not found exception
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ServiceNotFoundException extends IncidentsException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ServiceNotFoundException(String message) {
		super(message);
	}

}
