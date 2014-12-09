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
import com.siemens.demonstrator.client.translator.Translator;

/**
 * Responsible proxy for communication with the SPS
 */
public class SPSProxy extends ServiceProxy {

	public SPSProxy() {
		super();
		this.servicePath = Constant.HTTP_REQUEST_PREFIX
				+ Session.getInstance().getServiceList().getServiceList()
						.get(0).getPath();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_XML);
	}

	/**
	 * Sends a Tasking Request to the SPS
	 * 
	 * @param procedure
	 *            the sensor procedure
	 * @param values
	 *            the values to set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	public String submitTask(String procedure, String values)
			throws JAXBException, TransformerException,
			ParserConfigurationException, SAXException, IOException {
		this.contextPath = RestURIConstants.SPS_SUBMIT_TASK_STATUS;
		Translator translator = new Translator();
		String taskingRequest = translator.getSPSTaskingRequest(procedure,
				values);
		return this.doPost(taskingRequest);
	}
}