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
 * Responsible proxy for communication with the SES
 */
public class SESProxy extends ServiceProxy {

	public SESProxy() {
		super();
		this.servicePath = Constant.HTTP_REQUEST_PREFIX
				+ Session.getInstance().getServiceList().getServiceList()
						.get(1).getPath();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_XML);
	}

	/**
	 * Sends a Subscription to LeakDetection service notifications
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
	public String subscribeForLeakDetection() throws TransformerException,
			ParserConfigurationException, SAXException, IOException {
		this.contextPath = RestURIConstants.SES_SUBSCRIBE;
		Translator translator = new Translator();
		String leakDetectionSubscription = translator
				.getLeakDetectionSubscription();
		return this.doPost(leakDetectionSubscription);
	}
}
