/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.proxy;

import java.io.IOException;
import java.util.Arrays;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.springframework.http.MediaType;
import org.xml.sax.SAXException;

import com.siemens.demonstrator.client.init.Constant;
import com.siemens.demonstrator.client.init.Session;
import com.siemens.demonstrator.parser.main.SensorMLParser;
import com.siemens.demonstrator.parser.model.PhysicalComponent;

/**
 * Responsible proxy for communication with the Registry
 */
public class SOSProxy extends ServiceProxy {

	public SOSProxy() {
		super();
		this.servicePath = Constant.HTTP_REQUEST_PREFIX
				+ Session.getInstance().getServiceList().getServiceList()
						.get(2).getPath();
		headers.setAccept(Arrays.asList(MediaType
				.parseMediaType("application/gml+xml")));
		headers.setContentType(MediaType.parseMediaType("application/gml+xml"));
	}

/*	public String insertSensorObservation(RestObservation sosObservation)
			throws JAXBException {
		this.contextPath = RestURIConstants.SOS_INSERT_OBSERVATION;
		//OMParser omParser = new OMParser();
		String xmlObject = omParser.parseObject(sosObservation);
		return this.doPost(xmlObject);
	}
*/}
