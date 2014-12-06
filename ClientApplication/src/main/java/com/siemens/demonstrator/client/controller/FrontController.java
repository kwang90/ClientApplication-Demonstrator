package com.siemens.demonstrator.client.controller;

import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView index(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/dashboard.html", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView dashboardPage(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		return mv;
	}

	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public @ResponseBody String submitTask(
			@RequestParam(value = "procedure") String procedure,
			@RequestParam(value = "values") String values) {
		System.out.println("Tasking request received:" + procedure + ":"
				+ values);

		// SPSProxy spsProxy = new SPSProxy();
		// return spsProxy.submitTask(procedure, values);
		return "success";
	}

	@RequestMapping(value = "/sensor", method = RequestMethod.POST)
	public @ResponseBody String getSensorValue(
			@RequestParam(value = "procedure") String procedure) {
		System.out.println("SOS Observation request received:" + procedure);

		// FIXME add SOSProxy method to getObservation
		return "success";
	}

	@RequestMapping(value = "/statistics.html", method = RequestMethod.GET)
	public ModelAndView statisticsPage(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("statistics");
		return mv;
	}

	@RequestMapping(value = "/process/{processId}/sensors", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String getSensorsByProcessId(
			@PathVariable("processId") String processId) throws JSONException {
		System.out.println("Sensors for processId:" + processId);
		/*
		 * RegistryProxy registryProxy = new RegistryProxy(); try {
		 * PhysicalComponentList physicalComponentList = registryProxy
		 * .getPhysicalComponentListByProcessId(processId); JSONObject mainObj =
		 * new JSONObject(); JSONArray sensorsList = new JSONArray(); for
		 * (PhysicalComponent physicalComponent : physicalComponentList
		 * .getList()) { if (physicalComponent.getParameters() != null) for
		 * (Parameter parameter : physicalComponent
		 * .getParameters().getParametersList()) { JSONObject device = new
		 * JSONObject(); device.put("logicalId", physicalComponent
		 * .getIdentifier().getIdentifier()); device.put("type", "actuator"); if
		 * (parameter.getParameterType() instanceof Boolean)
		 * device.put("parameterType", "Boolean"); else
		 * device.put("parameterType", "Quantity"); device.put("parameterName",
		 * parameter.getName()); device.put("value", "NA");
		 * sensorsList.put(device); } if (physicalComponent.getOutputs() !=
		 * null) for (Output output : physicalComponent.getOutputs()
		 * .getOutputsList()) { JSONObject device = new JSONObject();
		 * device.put("logicalId", physicalComponent
		 * .getIdentifier().getIdentifier()); device.put("type", "sensor");
		 * device.put("parameterType", "Quantity"); device.put("parameterName",
		 * output.getName()); device.put("value", "NA");
		 * sensorsList.put(device); } } mainObj.put("devices", sensorsList);
		 * return mainObj.toString(); } catch (JAXBException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

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