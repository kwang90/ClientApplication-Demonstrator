/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.proxy;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Superclass for communication with the Registry, SOS, SES and SPS
 */
public class ServiceProxy {
	private final static Logger logger = Logger.getLogger(ServiceProxy.class);
	private RestTemplate restTemplate;
	protected HttpHeaders headers;
	private HttpEntity<String> httpEntity;
	protected String servicePath = null;
	protected String contextPath = null;

	public ServiceProxy() {
		restTemplate = new RestTemplate();
		headers = new HttpHeaders();
	}

	protected String doPost(String xmlObject) {
		httpEntity = new HttpEntity<String>(xmlObject, headers);
		ResponseEntity<String> response = restTemplate.exchange(servicePath
				+ contextPath, HttpMethod.POST, httpEntity, String.class);
		logger.info("doGet(): " + response.getBody());
		return response.getBody();
	}

	protected String doGet(String parameters) {
		httpEntity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(servicePath
				+ contextPath + parameters, HttpMethod.GET, httpEntity,
				String.class);
		logger.info("doGet(): " + response.getBody());
		return response.getBody();
	}

	protected String doPut(String parameters) {
		httpEntity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(servicePath
				+ contextPath + parameters, HttpMethod.PUT, httpEntity,
				String.class);
		logger.info("doGet(): " + response.getBody());
		return response.getBody();
	}

	protected String doDelete(String parameters) {
		httpEntity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(servicePath
				+ contextPath + parameters, HttpMethod.DELETE, httpEntity,
				String.class);
		logger.info("doGet(): " + response.getBody());
		return response.getBody();
	}
}