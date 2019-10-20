package com.montefiore.incidents.exception;

/**
 * This is the Application Level Exception class to capture all exceptions
 * thrown from application
 */
public class IncidentsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param IncidentsException
	 */
	public IncidentsException(String message) {
		super(message);
	}

}
