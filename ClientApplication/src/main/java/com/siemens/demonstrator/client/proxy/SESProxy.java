/**
 * Ahmed Shafei
 * Ahmed.Shafei@siemens.com
 */
package com.siemens.demonstrator.client.proxy;

import java.util.Arrays;

import org.springframework.http.MediaType;

import com.siemens.demonstrator.client.init.Constant;
import com.siemens.demonstrator.client.init.Session;

/**
 * Responsible proxy for communication with the SES
 */
public class SESProxy extends ServiceProxy {

	public SESProxy() {
		super();
		this.servicePath = Constant.HTTP_REQUEST_PREFIX
				+ Session.getInstance().getServiceList().getServiceList()
						.get(2).getPath();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_XML);
	}

}
