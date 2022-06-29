package com.bosch.tcsoaservice.tchelper;

public enum TCCredentials {
	NAME("des8kor"),
	PASSWORD("1234567890"),
	GROUP(""),
	ROLE(""),
	DISCRIMINATOR("");
	
	private String nativeName;

	TCCredentials(final String nativeName) {
		this.setNativeName(nativeName);
	}

	public void setNativeName(final String nativeName) {
		this.nativeName = nativeName;
	}

	public String getNativeName() {
		return nativeName;
	}

	@Override
	public String toString() {
		return this.nativeName;
	}
}
