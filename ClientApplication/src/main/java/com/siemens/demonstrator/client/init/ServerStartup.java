/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.init;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.xml.sax.SAXException;

import com.siemens.demonstrator.client.proxy.RegistryProxy;
import com.siemens.demonstrator.client.proxy.SESProxy;

/**
 * This bean is responsible for session initialization, fetching services list
 */
@PropertySource("classpath:client.properties")
public class ServerStartup {
	private final static Logger logger = Logger.getLogger(ServerStartup.class);
	private static final String PROPERTY_NAME_REGISTRY_IP = "192.168.1.3";
	private static final String PROPERTY_NAME_REGISTRY_PORT = "8095";

	@Resource
	private Environment env;

	@PostConstruct
	private void initiateData() {
		initializeSession();
		fetchServicesList();
		//subscribeToLeakDetectionNotifications();
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

	/**
	 * Subscribes to leak detection service notifications
	 */
	private void subscribeToLeakDetectionNotifications() {
		logger.info("PostConstruct: subscribeToLeakDetectionNotifications");
		SESProxy sesProxy = new SESProxy();
		try {
			sesProxy.subscribeForLeakDetection();
		} catch (TransformerException e) {
			logger.error(
					"Failed to subscribe to leak detection service, Exiting", e);
		} catch (ParserConfigurationException e) {
			logger.error(
					"Failed to subscribe to leak detection service, Exiting", e);
		} catch (SAXException e) {
			logger.error(
					"Failed to subscribe to leak detection service, Exiting", e);
		} catch (IOException e) {
			logger.error(
					"Failed to subscribe to leak detection service, Exiting", e);
		}
	}

	@PreDestroy
	private void cleanUp() {
		logger.info("PreDestroy: cleanUp");
	}
}