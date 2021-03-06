package com.geoip.main;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxmind.geoip.Country;
import com.maxmind.geoip.LookupService;

@RestController
@EnableAutoConfiguration
public class Lookup {

	private List<IPLocation> locations;
	
	public Lookup() {
		
	}
	
	public Lookup(List<IPLocation> locations) {
		this.locations = locations;
	}

	public List<IPLocation> resolve() throws LookupException {
		try {
			//Linux
			String fileName = getClass().getResource("/resources/GeoIP.dat").toExternalForm().substring(5);
			//Windows
//			String fileName = getClass().getResource("/resources/GeoIP.dat").toExternalForm().substring(6);
			LookupService lookupService = new LookupService(fileName, LookupService.GEOIP_CHECK_CACHE);
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
