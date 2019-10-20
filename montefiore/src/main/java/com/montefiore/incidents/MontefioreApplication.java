package com.montefiore.incidents;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/**
 * This is SpringBoot class for MontefioreApplication
 */
public class MontefioreApplication {

	private static Log log = LogFactory.getLog(MontefioreApplication.class);

	@Bean
	/**
	 * Spring REST Template injection
	 */
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/**
	 * Spring Boot Main
	 */
	public static void main(String[] args) {
		SpringApplication.run(MontefioreApplication.class, args);
	}

}
