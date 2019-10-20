package com.montefiore.incidents.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This is the Application Level Exception Handler to transform them to Incident
 * Exception using Custom Exception Details object
 */
@ControllerAdvice
@RestController
public class IncidentsExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionDetails exp = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exp, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(IncidentsException.class)
	public final ResponseEntity<Object> handleIncidentsExceptions(IncidentsException ex, WebRequest request) {
		ExceptionDetails exp = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ServiceNotFoundException.class)
	public final ResponseEntity<Object> handleServiceNotFoundExceptions(ServiceNotFoundException ex,
			WebRequest request) {
		ExceptionDetails exp = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exp, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionDetails exp = new ExceptionDetails(new Date(), "Input Validation Failure",
				ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exp, HttpStatus.BAD_REQUEST);
	}

}
