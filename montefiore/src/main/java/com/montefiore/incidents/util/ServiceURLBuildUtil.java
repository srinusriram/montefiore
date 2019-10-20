package com.montefiore.incidents.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.montefiore.incidents.config.IncidentsProperties;
import com.montefiore.incidents.dto.IncidentsRequest;
import com.montefiore.incidents.services.IncidentsServices;

/**
 * This is Incident Service Build URL Class, mainly to isolate the build process
 * so that if in case any later change are centralized at one place
 */
@Component
public class ServiceURLBuildUtil {

	private static Log log = LogFactory.getLog(IncidentsServices.class);

	@Autowired
	IncidentsProperties incidentsProperties;

	/**
	 * This Method is mainly to build Traffic Incident ServiceURL
	 */
	public String buildTrafficIncidentServiceURL(String key, IncidentsRequest request) {
		String serviceURL;
		String mapArea = request.getIncBb().getIncBBSLatitude() + "," + request.getIncBb().getIncBBWLongitude() + ","
			+ request.getIncBb().getIncBBNLatitude() + "," + request.getIncBb().getIncBBELongitude();
		String queryParams = mapArea + "?key=" + key;
		log.info("Traffic Incidents ServiceURL-" + incidentsProperties.getIncidentsTrafficServiceUrl() + "\n");
		serviceURL = incidentsProperties.getIncidentsTrafficServiceUrl() + queryParams;
		return serviceURL;
	}

	/**
	 * This Method is mainly to build Location Search ServiceURL
	 */
	public String buildLocationSearchServiceURL(double[] coordinates) {
		String queryParams = "?lattlong=" + coordinates[0] + "," + coordinates[1];
		String serviceURL = incidentsProperties.getLocationSearchServiceUrl() + queryParams;
		log.info("	Location Search ServiceURL-" + serviceURL);
		return serviceURL;
	}

	/**
	 * This Method is mainly to build Location WOEID ServiceURL
	 */
	public String buildLocationWOEIDServiceURL(int woeid) {
		String serviceURL = incidentsProperties.getLocationAPIServiceUrl() + woeid;
		log.info("	Location WOEID ServiceURL-" + serviceURL);
		return serviceURL;
	}
}
