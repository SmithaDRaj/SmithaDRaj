package com.bosch.creteItem.helper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.bosch.createItem.model.CreateItemInput;

public class SOAHelperImpl implements SOAHelper{
	private static final String serviceUrl = "http://localhost:8082/tcsoaserviceapi/services/tcsoaservice";

	/*@Override
	public String creteItem(Item item) {
		AppXSession   session = new AppXSession("https://si0vm4131.de.bosch.com:47211/tc");
		// Establish a session with the Teamcenter Server
        User user = session.login();
		// Get the service stub
        DataManagementService dmService = DataManagementService.getService(AppXSession.getConnection());
        ItemProperties itemProperty = new ItemProperties();
        
        itemProperty.clientId = "microservices";
        itemProperty.itemId = item.getId();
        itemProperty.revId = "0001";
        itemProperty.name = item.getName();
        itemProperty.type = item.getType();
        itemProperty.description = "Test Item for microservices poc.";
        itemProperty.uom = "";
        
        ItemProperties[] itemProps = new ItemProperties[1];
        itemProps[0] = itemProperty;
        CreateItemsResponse response = dmService.createItems(itemProps, null, "");
        System.out.println("Item created with item id ="+item.getId()+" and output is ="+response.output);
        // Terminate the session with the Teamcenter server
        session.logout();
		return "Item created with item id ="+item.getId()+" and output is ="+response.output;
	}*/
	
	@Override
	public String creteItem(CreateItemInput createItemInput) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serviceUrl).path("creteitem");
        System.out.println("Calling TCSOAService ="+target.getUri());
        String createdItemResponse = target.request().post(Entity.entity(createItemInput, MediaType.APPLICATION_XML), String.class);
        System.out.println(createdItemResponse);
        return createdItemResponse;
	}

}
