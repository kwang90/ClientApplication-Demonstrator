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

import org.springframework.http.MediaType;
import org.xml.sax.SAXException;

import com.siemens.demonstrator.client.init.Constant;
import com.siemens.demonstrator.client.init.Session;
import com.siemens.demonstrator.omparser.main.OMParser;
import com.siemens.demonstrator.omparser.model.ObservationCollection;

/**
 * Responsible proxy for communication with the SOS
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

	/**
	 * get SOS Observation
	 * 
	 * @param procedure
	 *            the sensor procedure
	 * @param temporalFilter
	 *            time filter for the sos observations
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	public ObservationCollection getObservation(String procedure,
			String namespaces, String temporalFilter) throws JAXBException,
			TransformerException, ParserConfigurationException, SAXException,
			IOException {
		this.contextPath = RestURIConstants.SOS_GET_OBSERVATION;
		OMParser omParser = new OMParser();
		ObservationCollection observations = omParser.parseXmlObservations(this
				.doGet("?procedures=" + procedure + "&namespaces=" + namespaces
						+ "&temporalFilter=" + temporalFilter));
		return observations;
	}

	/**
	 * get SOS Observation
	 * 
	 * @param procedure
	 *            the sensor procedure
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	public ObservationCollection getObservation(String procedure)
			throws JAXBException, TransformerException,
			ParserConfigurationException, SAXException, IOException {
		this.contextPath = RestURIConstants.SOS_GET_OBSERVATION;
		OMParser omParser = new OMParser();
		ObservationCollection observations = omParser.parseXmlObservations(this
				.doGet("?procedures=" + procedure));
		return observations;
	}
}