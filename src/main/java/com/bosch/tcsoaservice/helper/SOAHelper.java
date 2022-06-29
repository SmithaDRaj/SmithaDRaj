package com.bosch.tcsoaservice.helper;

import com.teamcenter.services.strong.core.DataManagementService;
import com.teamcenter.soa.client.model.ModelObject;

public interface SOAHelper {
	DataManagementService getTcSoaService(String host);
	ModelObject[] getModelObjectsFromUIDs(String[] arrayOfUIDs, DataManagementService dmService);
}
