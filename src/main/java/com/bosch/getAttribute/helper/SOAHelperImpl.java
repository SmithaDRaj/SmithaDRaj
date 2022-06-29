package com.bosch.getAttribute.helper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.bosch.getAttribute.model.GetAttributeInput;

public class SOAHelperImpl implements SOAHelper {
	private static final String serviceUrl = "http://localhost:8082/tcsoaserviceapi/services/tcsoaservice";

	@Override
	public String getAttribute(GetAttributeInput getAttributeInput) {
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serviceUrl).path("getattribute");
        System.out.println("Calling TCSOAService ="+target.getUri());
        String getAttributeResponse = target.request().post(Entity.entity(getAttributeInput, MediaType.APPLICATION_XML), String.class);
        System.out.println(getAttributeResponse);
		return getAttributeResponse;
	}	
}
