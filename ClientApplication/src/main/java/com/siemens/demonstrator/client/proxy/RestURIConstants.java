/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.proxy;

public class RestURIConstants {

	public static final String REGISTRY_SERVICES_LIST = "/service";

	public static final String REGISTRY_PHYSICAL_COMPONENT_LIST_PREFIX = "/process/";

	public static final String REGISTRY_PHYSICAL_COMPONENT_LIST_SUFFIX = "/sensors";

	public static final String SOS_SERVICE_CONTEXT = "/52n-sos-webapp/sos/rest";

	public static final String SOS_INSERT_SENSOR = "/52n-sos-webapp/sos/rest/sensors";

	public static final String SOS_INSERT_OBSERVATION = "/52n-sos-webapp/sos/rest/observations";// {?procedures,temporalFilter,spatialFilter,responseFormat}

	public static final String SOS_GET_OFFERINGS = "/52n-sos-webapp/sos/rest/offerings/o_";

	public static final String SPS_DOWNLOAD_LINK_PREFIX = "/sps/sml/DemonstratorActuator/";

	public static final String SPS_INSERT_SENSOR = "/sps/rest/sensor";

	public static final String SPS_UPDATE_TASK_STATUS = "/sps/rest/task";

	public static final String SES_NOTIFY_MESSAGE = "/rest/messages";
}
