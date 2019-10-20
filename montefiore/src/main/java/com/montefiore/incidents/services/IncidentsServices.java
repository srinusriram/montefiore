package com.montefiore.incidents.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.montefiore.incidents.config.IncidentsProperties;
import com.montefiore.incidents.dto.IncidentsRequest;
import com.montefiore.incidents.dto.IncidentsResponse;
import com.montefiore.incidents.dto.LocationDetails;
import com.montefiore.incidents.dto.Point;
import com.montefiore.incidents.dto.ResourceSets;
import com.montefiore.incidents.dto.Resources;
import com.montefiore.incidents.exception.IncidentsException;
import com.montefiore.incidents.security.IncidentsKeyDecrypt;
import com.montefiore.incidents.util.ServiceURLBuildUtil;

@Service
/**
 * This is Spring Service Class that provides the actual business implementation
 */
public class IncidentsServices {

	private static Log log = LogFactory.getLog(IncidentsServices.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	IncidentsProperties incidentsProperties;

	@Autowired
	IncidentsKeyDecrypt incidentKeyDecrypt;

	@Autowired
	ServiceURLBuildUtil serviceURLUtil;

	/**
	 * Default Constructor
	 */
	IncidentsServices() {
		// restTemplate = new RestTemplate();
	}

	/**
	 * This is the Service Method for the Traffic Incidents REST API
	 */
	public IncidentsResponse retrieveTrafficIncidents(IncidentsRequest incsReq)
			throws IncidentsException {
		String serviceURL = serviceURLUtil.buildTrafficIncidentServiceURL(incidentKeyDecrypt.getServiceKey(), incsReq);

		IncidentsResponse originData = restTemplate.getForObject(serviceURL, IncidentsResponse.class);
		IncidentsResponse finalData = getIncidentswithAvgTemps(originData, incsReq.getIncLimit());

		return finalData;
	}

	/**
	 * This method is mainly to traverse the TrafficIncidents resource sets
	 */
	private IncidentsResponse getIncidentswithAvgTemps(IncidentsResponse response, int incLimit) {
		List<Resources> resultResources;

		List<ResourceSets> sets = response.getResourceSets();
		for (ResourceSets set : sets) {
			resultResources = new ArrayList<Resources>(); // will add inline to specified limit

			List<Resources> resources = set.getResources();
			int rCount = incLimit;
			for (Resources resource : resources) {
				if (rCount == 0)
					break;
				log.debug("*******************************************");
				resource = computeIncidentAvgMinMaxTemps(resource); // To compute Temps at each Resource level
				resultResources.add(resource);

				rCount--;
			}
			set.setResources(resultResources);
		}
		return response;
	}

	/**
	 * This method is mainly to traverse the Incidents Resource and invoke Location
	 * search for each Geo Location
	 */
	private Resources computeIncidentAvgMinMaxTemps(Resources resource) {
		String serviceURL;
		double[] coordinates;

		double avgIncMinTemp = 0;
		double avgIncMaxTemp = 0;

		coordinates = ((Point) resource.getPoint()).getCoordinates();
		log.info("IncidentId-" + resource.getIncidentId() + " | Latitude-" + coordinates[0]
				+ " | Longitude-"
				+ coordinates[1]);

		// Get WOEID's for each coordinates
		serviceURL = serviceURLUtil.buildLocationSearchServiceURL(coordinates);
		ResponseEntity<List<LocationDetails>> locationResponse = restTemplate.exchange(serviceURL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<LocationDetails>>() {
				});
		List<LocationDetails> locations = locationResponse.getBody();
		log.info("	WOEID's Found -" + locations.size());

		for (LocationDetails location : locations) {
			serviceURL = serviceURLUtil.buildLocationWOEIDServiceURL(location.getWoeid());
			String woeidResponse = restTemplate.getForObject(serviceURL, String.class);
			double[] avgWoeidTemps = computeWOEIDAvgMinMaxTemps(woeidResponse);
			avgIncMinTemp += avgWoeidTemps[0];
			avgIncMaxTemp += avgWoeidTemps[1];
			log.debug("	total consolidated_weather: avgIncMinTemp - " + avgIncMinTemp + "avgIncMaxTemp- "
					+ avgIncMaxTemp);
			log.debug("===============================================================");
		}
		avgIncMinTemp = avgIncMinTemp / locations.size();
		avgIncMaxTemp = avgIncMaxTemp / locations.size();
		log.info(
				"IncidentAvgMinMaxTemps: avgIncMinTemp - " + avgIncMinTemp + "avgIncMaxTemp- " + avgIncMaxTemp + "\n");
		resource.setAvgMax(new Double(avgIncMaxTemp).intValue());
		resource.setAvgMin(new Double(avgIncMinTemp).intValue());

		return resource;
	}

	/**
	 * This method is mainly to traverse the Incidents Resource and invoke Location
	 * search for each Geo Location
	 */
	private double[] computeWOEIDAvgMinMaxTemps(String woeidResponse) {
		double[] avgWoeidTemps = new double[2];

		int count = 0;
		double totalWoeidMinTemp = 0;
		double totalWoeidMaxTemp = 0;

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode consolidatedWeatherNode;
		try {

			// Retrieve weather JSONNode array to process for later Avg temps
			consolidatedWeatherNode = ((JsonNode) objectMapper.readTree(woeidResponse))
					.path(incidentsProperties.getLocationAPIWeatherNode());
			if (consolidatedWeatherNode.isArray()) {
				for (JsonNode node : consolidatedWeatherNode) {
					// Each WOEID
					totalWoeidMinTemp += node.path("min_temp").asDouble();
					totalWoeidMaxTemp += node.path("max_temp").asDouble();
					count++;
					log.debug("	consolidated_weather: min_temp - " + node.path("min_temp").asDouble()
							+ "max_temp- " + node.path("max_temp").asDouble());
					log.debug("	consolidated_weather: totalWoeidMinTemp - " + totalWoeidMinTemp
							+ "totalWoeidMaxTemp- " + totalWoeidMaxTemp);
				}
			}
		} catch (IOException exp) {
			throw new IncidentsException("Exception-IncidentsServices/computeWOEIDAvgMinMaxTemps:" + exp.getMessage());
		}

		// Computing Avg Temps for all the WOEID of given Geo Location
		double avgWoeidMinTemp = totalWoeidMinTemp / count;
		double avgWoeidMaxTemp = totalWoeidMaxTemp / count;
		log.debug("	consolidated_weather: avgWoeidMinTemp - " + avgWoeidMinTemp + "avgWoeidMaxTemp- "
				+ avgWoeidMaxTemp);
		avgWoeidTemps[0] = avgWoeidMinTemp;
		avgWoeidTemps[1] = avgWoeidMaxTemp;

		return avgWoeidTemps; // Avg Max & Min for given Geo Location
	}

}
