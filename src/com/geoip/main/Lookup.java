package com.geoip.main;

import java.io.IOException;
import java.util.List;

import com.maxmind.geoip.Country;
import com.maxmind.geoip.LookupService;

public class Lookup {

	private List<IPLocation> locations;
	

	public Lookup(List<IPLocation> locations) {
		this.locations = locations;
	}

	public List<IPLocation> resolve() throws LookupException {
		try {
			//Linux
			String fileName = getClass().getResource("/resources/GeoIP.dat").toExternalForm().substring(5);
			//Windows
//			String fileName = getClass().getResource("/resources/GeoIP.dat").toExternalForm().substring(6);
			LookupService lookupService = new LookupService(fileName);
			for (IPLocation location : locations) {
				Country country = lookupService.getCountry(location.ipAddress());
				location.setCountry(country.getName());
			}			
			return locations;
		} catch (IOException e) {
			throw new LookupException("There was an error looking up Countries", e);
		}
		
	}

}
