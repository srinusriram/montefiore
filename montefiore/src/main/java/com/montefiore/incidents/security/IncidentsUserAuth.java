package com.montefiore.incidents.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
/*
 * This Class is create a test user for securing the Traffic Incidents service ,
 * use this user for Service Auth using Basic Authentication
 */
public class IncidentsUserAuth extends WebSecurityConfigurerAdapter {

	// Creation of Test User for service auth
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password("{noop}montefiore").roles("ADMIN");
	}

	// Secure endpoins with HTTP Basic authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// HTTP Basic authentication
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/montefiore/**").hasRole("ADMIN").and()
				.csrf().disable().formLogin()
				.disable();
	}
}