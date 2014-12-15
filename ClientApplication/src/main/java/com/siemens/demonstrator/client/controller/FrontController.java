package com.siemens.demonstrator.client.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.siemens.demonstrator.client.proxy.RegistryProxy;
import com.siemens.demonstrator.client.proxy.SOSProxy;
import com.siemens.demonstrator.client.proxy.SPSProxy;
import com.siemens.demonstrator.omparser.model.OM_Observation;
import com.siemens.demonstrator.omparser.model.OM_Result;
import com.siemens.demonstrator.omparser.model.ObservationCollection;
import com.siemens.demonstrator.omparser.model.RestObservation;
import com.siemens.demonstrator.parser.model.Output;
import com.siemens.demonstrator.parser.model.Parameter;
import com.siemens.demonstrator.parser.model.PhysicalComponent;
import com.siemens.demonstrator.parser.model.PhysicalComponentList;

/**
 * Controller class is a bit hardcoded, since it was done very quickly.
 * Refactoring will be done afterwards Documentation is not currently available,
 * comments will be added later
 *
 */
@Controller
public class FrontController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:index.html";
	}

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/dashboard.html", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView dashboardPage(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		return mv;
	}

	@RequestMapping(value = "/statistics.html", method = RequestMethod.GET)
	public ModelAndView statisticsPage(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("statistics");
		return mv;
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.POST)
	public @ResponseBody String submitTask(
			@RequestParam(value = "procedure") String procedure,
			@RequestParam(value = "values") String values) {
		try {
			SPSProxy spsProxy = new SPSProxy();
			return spsProxy.submitTask(procedure, values);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/notifications", method = RequestMethod.GET)
	public @ResponseBody String getSESNotifications(
			@RequestParam(value = "id") int id) {
		System.out.println("SES Notifications after first:" + id
				+ " notifications");
		// FIXME send all notifications which have ids greater than 0.
		return null;
	};

	@RequestMapping(value = "/notifications", method = RequestMethod.POST)
	public @ResponseBody String receiveSESNotifications(
			@RequestBody String sesNotification) {
		// FIXME call SESRest to parse the incoming notification according to
		// XML file, then save it in a database.
		return null;
	};

	@RequestMapping(value = "/sensors/{procedure}/value", method = RequestMethod.GET)
	public @ResponseBody String getSensorValue(
			@PathVariable(value = "procedure") String procedure) {
		try {
			SOSProxy sosProxy = new SOSProxy();
			String namespaces = "xmlns(om,http://www.opengis.net/om/2.0)";
			String temporalFilter = "om:phenomenonTime,latest";
			ObservationCollection observations = sosProxy.getObservation(
					procedure, namespaces, temporalFilter);
			if (observations != null && observations.getCollection() != null
					&& observations.getCollection().size() > 0) {
				OM_Result result = observations.getCollection().get(0)
						.getObservation().getResult();
				return result.getValue() + " " + result.getUom();
			} else
				return "N/A";
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "N/A";
	}

	@RequestMapping(value = "/sensors/{procedure}/chart", method = RequestMethod.GET)
	public @ResponseBody String getSensorChart(
			@PathVariable(value = "procedure") String procedure)
			throws JSONException {
		try {
			SimpleDateFormat dateformat = new SimpleDateFormat(
					"yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			Date startDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			calendar.add(Calendar.MINUTE, -2);
			Date endDate = calendar.getTime();

			SOSProxy sosProxy = new SOSProxy();
			String namespaces = "xmlns(om,http://www.opengis.net/om/2.0)";
			System.out.println("Start date:" + dateformat.format(startDate));
			System.out.println("Date date:" + dateformat.format(endDate));
			String temporalFilter = "om:phenomenonTime,"
					+ dateformat.format(startDate) + "/"
					+ dateformat.format(endDate);
			ObservationCollection observations = sosProxy.getObservation(
					procedure, namespaces, temporalFilter);
			if (observations != null && observations.getCollection() != null
					&& observations.getCollection().size() > 0) {
				JSONObject mainObj = new JSONObject();
				JSONArray dataList = new JSONArray();
				mainObj.put("uom", observations.getCollection().get(0)
						.getObservation().getResult().getUom());
				for (RestObservation restObservation : observations
						.getCollection()) {
					OM_Observation observation = restObservation
							.getObservation();
					JSONObject point = new JSONObject();
					point.put("time", observation.getPhenomenonTime()
							.getTimeInstant().getTimePosition().getValue());
					point.put("value", observation.getResult().getValue());
					dataList.put(point);
				}
				mainObj.put("data", dataList);
				return mainObj.toString();
			} else
				return null;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "N/A";
	}

	@RequestMapping(value = "/processes/{processId}/sensors", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String getSensorsByProcessId(
			@PathVariable("processId") String processId) throws JSONException {
		try {
			RegistryProxy registryProxy = new RegistryProxy();
			PhysicalComponentList physicalComponentList = registryProxy
					.getPhysicalComponentListByProcessId(processId);
			JSONObject mainObj = new JSONObject();
			JSONArray sensorsList = new JSONArray();
			for (PhysicalComponent physicalComponent : physicalComponentList
					.getList()) {
				if (physicalComponent.getParameters() != null)
					for (Parameter parameter : physicalComponent
							.getParameters().getParametersList()) {
						JSONObject device = new JSONObject();
						device.put("logicalId", physicalComponent
								.getIdentifier().getIdentifier());
						device.put("type", "actuator");
						if (parameter.getParameterType() instanceof com.siemens.demonstrator.parser.model.Boolean)
							device.put("parameterType", "Boolean");
						else
							device.put("parameterType", "Quantity");
						device.put("parameterName", parameter.getName());
						device.put("value", "NA");
						sensorsList.put(device);
					}
				if (physicalComponent.getOutputs() != null)
					for (Output output : physicalComponent.getOutputs()
							.getOutputsList()) {
						JSONObject device = new JSONObject();
						device.put("logicalId", physicalComponent
								.getIdentifier().getIdentifier());
						device.put("type", "sensor");
						device.put("parameterType", "Quantity");
						device.put("parameterName", output.getName());
						device.put("value", "NA");
						sensorsList.put(device);
					}
			}

			mainObj.put("devices", sensorsList);
			return mainObj.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/sensors", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String getAllSensors() throws JSONException {
		try {
			RegistryProxy registryProxy = new RegistryProxy();
			PhysicalComponentList physicalComponentList = registryProxy
					.getPhysicalComponentList();
			JSONObject mainObj = new JSONObject();
			JSONArray sensorsList = new JSONArray();
			for (PhysicalComponent physicalComponent : physicalComponentList
					.getList()) {
				if (physicalComponent.getOutputs() != null)
					for (Output output : physicalComponent.getOutputs()
							.getOutputsList()) {
						JSONObject device = new JSONObject();
						device.put("logicalId", physicalComponent
								.getIdentifier().getIdentifier());
						device.put("processId",
								physicalComponent.getDescription());
						device.put("type", "sensor");
						if (output.getParameter() instanceof com.siemens.demonstrator.parser.model.Boolean)
							device.put("parameterType", "Boolean");
						else
							device.put("parameterType", "Quantity");
						device.put("parameterName", output.getName());
						device.put("value", "NA");
						sensorsList.put(device);
					}
			}
			mainObj.put("devices", sensorsList);
			return mainObj.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String loadDummySensors(String processId) throws JSONException {
		JSONObject mainObj = new JSONObject();
		JSONArray sensorsList = new JSONArray();

		if (processId.equalsIgnoreCase("House 1")) {
			JSONObject pump = new JSONObject();
			pump.put("logicalId", "100");
			pump.put("type", "actuator");
			pump.put("parameterName", "Pump 1:State");
			pump.put("parameterType", "Boolean");
			pump.put("value", "0");

			JSONObject sensor = new JSONObject();
			sensor.put("logicalId", "200");
			sensor.put("type", "sensor");
			sensor.put("parameterName", "Flow 1:State");
			sensor.put("parameterType", "Quantity");
			sensor.put("value", "15 mm");

			sensorsList.put(pump);
			sensorsList.put(sensor);
		} else if (processId.equalsIgnoreCase("House 2")) {
			JSONObject pump = new JSONObject();
			pump.put("logicalId", "100");
			pump.put("type", "actuator");
			pump.put("parameterName", "Pump 2:State");
			pump.put("parameterType", "Boolean");
			pump.put("value", "1");

			JSONObject sensor = new JSONObject();
			sensor.put("logicalId", "200");
			sensor.put("type", "actuator");
			sensor.put("parameterName", "Flow 2:Sampling Rate");
			sensor.put("parameterType", "Quantity");
			sensor.put("value", "2");

			sensorsList.put(pump);
			sensorsList.put(sensor);

		} else if (processId.equalsIgnoreCase("Fresh")) {
			JSONObject pump = new JSONObject();
			pump.put("logicalId", "100");
			pump.put("type", "actuator");
			pump.put("parameterName", "Pump 3:State");
			pump.put("parameterType", "Boolean");
			pump.put("value", "1");

			JSONObject sensor = new JSONObject();
			sensor.put("logicalId", "200");
			sensor.put("type", "sensor");
			sensor.put("parameterName", "Flow 3:State");
			sensor.put("parameterType", "Quantity");
			sensor.put("value", "15 mm");

			sensorsList.put(pump);
			sensorsList.put(sensor);

		} else if (processId.equalsIgnoreCase("Sewage")) {
		}
		mainObj.put("devices", sensorsList);
		System.out.println(mainObj.toString());
		return mainObj.toString();
	}
}