package com.bosch.createItem.controller;

import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.createItem.model.CreateItemInput;
import com.bosch.creteItem.helper.SOAHelper;
import com.bosch.creteItem.helper.SOAHelperImpl;

@RestController
@RequestMapping("/createitemapi")
public class CreateItemController {

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public String createItem(@RequestBody CreateItemInput item) throws URISyntaxException {
		SOAHelper helper = new SOAHelperImpl();
		System.out.println("CreateItem request recieved for itemId ="+item.getId());
	    return helper.creteItem(item);
	}
}
