/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Service class model representation
 */

@XmlRootElement
public class Service {

	private String name;
	private String id;
	private String path;

	protected Service() {

	}

	/**
	 * @param name
	 * @param id
	 * @param path
	 */
	public Service(String name, String id, String path) {
		super();
		this.name = name;
		this.id = id;
		this.path = path;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@XmlElement(name = "service_name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	@XmlElement(name = "id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param ipAddress
	 *            the ipAddress to set
	 */
	@XmlElement(name = "ip_address")
	public void setPath(String path) {
		this.path = path;
	}
}
