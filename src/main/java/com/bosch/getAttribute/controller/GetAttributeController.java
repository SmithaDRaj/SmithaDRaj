package com.bosch.getAttribute.controller;

import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.getAttribute.helper.SOAHelper;
import com.bosch.getAttribute.helper.SOAHelperImpl;
import com.bosch.getAttribute.model.GetAttributeInput;

@RestController
@RequestMapping("/getattributeapi")
public class GetAttributeController {

	@RequestMapping(value = "/getAttributeInput", method = RequestMethod.POST)
	public String getAttributes(@RequestBody GetAttributeInput getAttributeInput) throws URISyntaxException {
		SOAHelper helper = new SOAHelperImpl();
		System.out.println("getAttribute request recieved for itemId ="+getAttributeInput.getId());
	    return helper.getAttribute(getAttributeInput);
	}
}
