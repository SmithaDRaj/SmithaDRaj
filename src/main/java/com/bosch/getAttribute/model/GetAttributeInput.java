package com.bosch.getAttribute.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetAttributeInput")
public class GetAttributeInput {
	private String id;
	private String attr;
	private String attrValue;
	private String host;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getAttrValue() {
		return attrValue;
	}
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
}
