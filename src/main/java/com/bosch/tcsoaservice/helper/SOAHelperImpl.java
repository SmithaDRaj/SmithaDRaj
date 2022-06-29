package com.bosch.tcsoaservice.helper;

import java.util.ArrayList;

import com.bosch.tcsoaservice.tchelper.AppXSession;
import com.bosch.tcsoaservice.tchelper.TCCredentials;
import com.teamcenter.services.strong.core.DataManagementService;
import com.teamcenter.soa.client.Connection;
import com.teamcenter.soa.client.model.ModelObject;
import com.teamcenter.soa.client.model.ServiceData;

public class SOAHelperImpl implements SOAHelper {

	@Override
	public DataManagementService getTcSoaService(String host) {
		System.out.println("Getting TCSOA service connection");
		// Get the service stub
		DataManagementService dmService = DataManagementService.getService(getConnection(host));
		return dmService;
	}

	public static Connection getConnection(String host) {
		AppXSession session = new AppXSession(host);
		// Establish a session with the Teamcenter Server
		session.login(TCCredentials.NAME.getNativeName(),TCCredentials.PASSWORD.getNativeName(),TCCredentials.GROUP.getNativeName(),TCCredentials.ROLE.getNativeName(),TCCredentials.DISCRIMINATOR.getNativeName());
		return AppXSession.getConnection();
	}

	@Override
	public ModelObject[] getModelObjectsFromUIDs(String[] arrayOfUIDs, DataManagementService dmService) {

		ModelObject[] arrModelObjects = null;

		if (arrayOfUIDs.length > 0) {
			ArrayList<ModelObject> modelObjects = new ArrayList<ModelObject>(arrayOfUIDs.length);
			// This will load objects and provide you as ServiceData plainobjects
			ServiceData loadObjects = dmService.loadObjects(arrayOfUIDs);
			for (int i = 0; i < loadObjects.sizeOfPlainObjects(); i++) {
				// Collect all the objects for given UIDs in array list
				modelObjects.add(loadObjects.getPlainObject(i));
			}
			if (modelObjects != null && modelObjects.size() > 0) {
				// Java method to convert array list to array
				arrModelObjects = modelObjects.toArray(new ModelObject[0]);
			}
		}
		return arrModelObjects;
	}
}
