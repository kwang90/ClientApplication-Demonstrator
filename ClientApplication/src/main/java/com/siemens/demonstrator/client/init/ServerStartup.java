/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.init;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.siemens.demonstrator.client.proxy.RegistryProxy;

/**
 * This bean is responsible for session initialization, fetching services list
 */
@PropertySource("classpath:client.properties")
public class ServerStartup {
	private final static Logger logger = Logger.getLogger(ServerStartup.class);
	private static final String PROPERTY_NAME_REGISTRY_IP = "192.168.1.1";
	private static final String PROPERTY_NAME_REGISTRY_PORT = "8095";

	@Resource
	private Environment env;

	@PostConstruct
	private void initiateData() {
		initializeSession();
		// fetchServicesList();
	}

	/**
	 * Initializes session related variables from gateway.properties
	 */
	private void initializeSession() {
		logger.info("PostConstruct: initializeSession");
		Session.getInstance().setRegistryIP(PROPERTY_NAME_REGISTRY_IP);
		Session.getInstance().setRegistryPort(
				Integer.parseInt(PROPERTY_NAME_REGISTRY_PORT));
		/**
		 * Uncomment this line to disable SensorMLParser debugging
		 */
		// SensorMLParser.DEBUG = false;
	}

	/**
	 * Fetches list of available 52north services from the Registry
	 */
	private void fetchServicesList() {
		logger.info("PostConstruct: fetchServicesList");
		RegistryProxy registryProxy = new RegistryProxy();
		try {
			registryProxy.getServicesList();
		} catch (JAXBException e) {
			logger.error("Failed to load services list, Exiting", e);
			System.exit(0);
		}
	}

	@PreDestroy
	private void cleanUp() {
		logger.info("PreDestroy: cleanUp");
	}
}