package com.bosch.createItem.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CreateItemInput")
public class CreateItemInput{
	private String id;
	private String name;
	private String type;
	private String host;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
}
