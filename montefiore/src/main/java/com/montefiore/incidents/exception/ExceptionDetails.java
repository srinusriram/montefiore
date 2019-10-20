package com.montefiore.incidents.exception;

import java.util.Date;

/**
 * This Class is mainly to encapsulate the Error message in custom defined
 * variables and return the response to user
 */
public class ExceptionDetails {

	private Date timestamp;
	private String message;
	private String details;

	/**
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ExceptionDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/*
	 * ExceptionDetails to String
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExceptionDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}

}
