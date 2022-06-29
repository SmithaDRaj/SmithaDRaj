package com.bosch.tcsoaservice.tcmethods;

import org.springframework.stereotype.Service;

import com.bosch.tcsoaservice.helper.SOAHelper;
import com.bosch.tcsoaservice.helper.SOAHelperImpl;
import com.bosch.tcsoaservice.model.CreateItemInput;
import com.bosch.tcsoaservice.model.GetAttributeInput;
import com.teamcenter.services.strong.core.DataManagementService;
import com.teamcenter.services.strong.core._2006_03.DataManagement.CreateItemsResponse;
import com.teamcenter.services.strong.core._2006_03.DataManagement.ItemProperties;
import com.teamcenter.soa.client.model.ModelObject;
import com.teamcenter.soa.client.model.ServiceData;
import com.teamcenter.soa.exceptions.NotLoadedException;

@Service
public class TCMethodsServiceImpl implements TCMethodsService{
	
	@Override
	public String createItem(CreateItemInput createItemInput) {
		System.out.println("CreteItem request received in TCSOAService for "+createItemInput.getId());
		ItemProperties itemProperty = new ItemProperties();
        itemProperty.clientId = "microservices";
        itemProperty.itemId = createItemInput.getId();
        itemProperty.revId = "0001";
        itemProperty.name = createItemInput.getName();
        itemProperty.type = createItemInput.getType();
        itemProperty.description = "Test Item for microservices poc.";
        itemProperty.uom = "";
        
        ItemProperties[] itemProps = new ItemProperties[1];
        itemProps[0] = itemProperty;
        SOAHelper helper = new SOAHelperImpl();
        CreateItemsResponse response = helper.getTcSoaService(createItemInput.getHost()).createItems(itemProps, null, "");
        System.out.println("Item created with item id ="+createItemInput.getId()+" and output is ="+response.output);
		return "Item created with item id ="+createItemInput.getId();
	}

	@Override
	public String getAttribute(GetAttributeInput getAttributeInput) throws NotLoadedException {
		System.out.println("GetAttribute request received in TCSOAService for "+getAttributeInput.getId());
		SOAHelper helper = new SOAHelperImpl();
		DataManagementService tcSoaService = helper.getTcSoaService(getAttributeInput.getHost());
		String[] uids = {getAttributeInput.getId()};
		ModelObject[] modelObjectsFromUIDs = helper.getModelObjectsFromUIDs(uids, tcSoaService);
		ServiceData properties = tcSoaService.getProperties( modelObjectsFromUIDs, new String[]{getAttributeInput.getAttr()} );
        System.out.println("Output is ="+properties.getPlainObject(0).getPropertyDisplayableValue(getAttributeInput.getAttr()));
		return "Attribute value is ="+properties.getPlainObject(0).getPropertyDisplayableValue(getAttributeInput.getAttr());
	}
	
}
