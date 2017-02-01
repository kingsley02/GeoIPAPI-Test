package com.geoip.main;

public class IPLocation {

	private String ipAddress;
	private String country;

	public IPLocation(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String ipAddress() {
		return ipAddress;
	}

	public void setCountry(String country) {
		this.country = country;
		
	}

}
