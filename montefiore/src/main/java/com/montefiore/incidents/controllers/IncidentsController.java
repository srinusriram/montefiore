package com.montefiore.incidents.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.montefiore.incidents.dto.IncidentsRequest;
import com.montefiore.incidents.dto.IncidentsResponse;
import com.montefiore.incidents.exception.IncidentsException;
import com.montefiore.incidents.exception.ServiceNotFoundException;
import com.montefiore.incidents.services.IncidentsServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "Traffic  Incidents System")
/**
 * This is Spring Controller Class Incidents , exposing REST API
 */
public class IncidentsController {

	private static Log log = LogFactory.getLog(IncidentsController.class);

	// Incidents Service injection
	@Autowired
	private IncidentsServices incServices;

	@ApiOperation(value = "Retrieve list of Traffic Incidents", response = IncidentsResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved Incidents"),
			@ApiResponse(code = 404, message = "Service is not found") })
	@GetMapping(value = "/retrieveTrafficIncidents", produces = "application/json")
	public ResponseEntity<IncidentsResponse> retrieveTrafficIncidents(@RequestParam(value = "incsReq") String incsReq) {
		IncidentsResponse response = null;
		try {
			// Mapping the request to Incident Requests
			IncidentsRequest incsReqDetails = new ObjectMapper().readValue(incsReq, IncidentsRequest.class);
			log.info("START - retrieveTrafficIncidents\n");
			response = incServices.retrieveTrafficIncidents(incsReqDetails);
			log.info("END - retrieveTrafficIncidents");
		} catch (ServiceNotFoundException snfExp) {
			throw new IncidentsException(
					"Exception-IncidentsController/retrieveTrafficIncidents:" + snfExp.getMessage());
		} catch (IncidentsException iExp) {
			throw new IncidentsException("Exception-IncidentsController/retrieveTrafficIncidents:" + iExp.getMessage());
		} catch (Exception exp) {
			throw new IncidentsException("Exception-IncidentsController/retrieveTrafficIncidents:" + exp.getMessage());
		}
		return ResponseEntity.ok(response);
	}
}
