package com.bosch.tcsoaservice.tcmethods;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.bosch.tcsoaservice.model.CreateItemInput;
import com.bosch.tcsoaservice.model.GetAttributeInput;
import com.teamcenter.soa.exceptions.NotLoadedException;

@Path("/tcsoaservice")
public interface TCMethodsService {
	
	@Path("/creteitem")
	@POST
	String createItem(CreateItemInput createItemInput);
	
	@Path("/getattribute")
	@POST
	String getAttribute(GetAttributeInput getAttributeInput) throws NotLoadedException;
	
}
