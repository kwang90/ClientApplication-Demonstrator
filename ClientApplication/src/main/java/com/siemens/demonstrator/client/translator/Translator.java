package com.siemens.demonstrator.client.translator;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.siemens.demonstrator.client.init.Constant;

public class Translator {

	public Translator() {

	}

	public String getSPSTaskingRequest(String procedure, String values)
			throws TransformerException, ParserConfigurationException,
			SAXException, IOException {
		InputStream fileIo = Translator.class
				.getResourceAsStream(Constant.TASKING_REQUEST_DOCUMENT);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fileIo);
		Element documentElement = doc.getDocumentElement();

		documentElement
				.getElementsByTagName(
						Constant.TASKING_REQUEST_PROCEDURE_ELEMENT).item(0)
				.setTextContent(procedure);

		Element parameterData = (Element) ((Element) documentElement
				.getElementsByTagName(
						Constant.TASKING_REQUEST_TASKING_PARAMETERS_ELEMENT)
				.item(0)).getElementsByTagName(
				Constant.TASKING_REQUEST_PARAMETERS_DATA_ELEMENT).item(0);
		parameterData
				.getElementsByTagName(Constant.TASKING_REQUEST_VALUES_ELEMENT)
				.item(0).setTextContent(values);

		DOMSource domSource = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);
		System.out.println(writer.toString());
		return writer.toString();
	}

	public String getLeakDetectionSubscription() throws TransformerException,
			ParserConfigurationException, SAXException, IOException {
		InputStream fileIo = Translator.class
				.getResourceAsStream(Constant.LEAK_DETECTION_SUBSCRIPTION_DOCUMENT);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fileIo);
		DOMSource domSource = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);
		System.out.println(writer.toString());
		return writer.toString();
	}
}
