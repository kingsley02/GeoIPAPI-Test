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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IPLocation other = (IPLocation) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IPLocation [ipAddress=" + ipAddress + ", country=" + country + "]";
	}
	
	

}
