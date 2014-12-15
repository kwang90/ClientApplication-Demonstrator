/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.proxy;

import java.io.StringReader;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;

import com.siemens.demonstrator.client.init.Constant;
import com.siemens.demonstrator.client.init.Session;
import com.siemens.demonstrator.client.model.ServiceList;
import com.siemens.demonstrator.parser.main.SensorMLParser;
import com.siemens.demonstrator.parser.model.PhysicalComponentList;

/**
 * Responsible proxy for communication with the Registry
 */
public class RegistryProxy extends ServiceProxy {
	final static Logger logger = Logger.getLogger(ServiceProxy.class);

	public RegistryProxy() {
		super();
		this.servicePath = Constant.HTTP_REQUEST_PREFIX
				+ Session.getInstance().getRegistryIP() + ":"
				+ Session.getInstance().getRegistryPort();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_XML);
	}

	/**
	 * Fetches the {@link ServiceList} from the registry.
	 */
	public void getServicesList() throws JAXBException {
		this.contextPath = RestURIConstants.REGISTRY_SERVICES_LIST;
		parseServicesList(this.doGet(""));
	}

	/**
	 * Fetches the {@link PhysicalComponentList} from the registry belonging to
	 * one processId
	 */
	public PhysicalComponentList getPhysicalComponentListByProcessId(
			String processId) throws JAXBException {
		this.contextPath = RestURIConstants.REGISTRY_PHYSICAL_COMPONENT_LIST_PREFIX
				+ "/"
				+ processId
				+ RestURIConstants.REGISTRY_PHYSICAL_COMPONENT_LIST_SUFFIX;
		String xmlString = this.doGet("");
		SensorMLParser sensormlParser = new SensorMLParser();
		return sensormlParser.parsePhysicalComponentList(xmlString);
	}

	private void parseServicesList(String xmlServiceList) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ServiceList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(xmlServiceList);
		Session.getInstance().setServiceList(
				(ServiceList) jaxbUnmarshaller.unmarshal(reader));
	}

	/**
	 * Fetches the {@link PhysicalComponentList} from the registry.
	 */
	public PhysicalComponentList getPhysicalComponentList()
			throws JAXBException {
		this.contextPath = RestURIConstants.REGISTRY_PHYSICAL_COMPONENT_LIST_PREFIX
				+ RestURIConstants.REGISTRY_PHYSICAL_COMPONENT_LIST_SUFFIX;
		String xmlString = this.doGet("");
		SensorMLParser sensormlParser = new SensorMLParser();
		return sensormlParser.parsePhysicalComponentList(xmlString);
	}
}