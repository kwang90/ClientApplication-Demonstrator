/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.init;

import com.siemens.demonstrator.client.model.ServiceList;

/**
 * Handles all session related variables
 */
public class Session {

	private static Session thisInstance;

	private String gatewayId = null;
	private String registryIP = null;
	private int registryPort;
	private ServiceList serviceList = null;

	static {
		thisInstance = new Session();
	}

	private Session() {
	}

	public static Session getInstance() {
		return thisInstance;
	}

	/**
	 * @return the registryIP
	 */
	public String getRegistryIP() {
		return registryIP;
	}

	/**
	 * @param registryIP
	 *            the registryIP to set
	 */
	public void setRegistryIP(String registryIP) {
		this.registryIP = registryIP;
	}

	/**
	 * @return the gatewayId
	 */
	public String getGatewayId() {
		return gatewayId;
	}

	/**
	 * @param gatewayId
	 *            the gatewayId to set
	 */
	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}

	/**
	 * @return the serviceList
	 */
	public ServiceList getServiceList() {
		return serviceList;
	}

	/**
	 * @param serviceList
	 *            the serviceList to set
	 */
	public void setServiceList(ServiceList serviceList) {
		this.serviceList = serviceList;
	}

	/**
	 * @return the registryPort
	 */
	public int getRegistryPort() {
		return registryPort;
	}

	/**
	 * @param registryPort
	 *            the registryPort to set
	 */
	public void setRegistryPort(int registryPort) {
		this.registryPort = registryPort;
	}
}