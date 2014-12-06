/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 */
@XmlRootElement(name = "service_list")
public class ServiceList {

	private List<Service> serviceList;

	protected ServiceList() {

	}

	public ServiceList(List<Service> serviceList) {
		super();
		this.serviceList = serviceList;
	}

	public List<Service> getServiceList() {
		return serviceList;
	}

	@XmlElement(name = "service")
	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}
}