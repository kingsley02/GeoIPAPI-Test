package com.geoip.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import com.geoip.main.IPLocation;
import com.geoip.main.Lookup;

public class CountryTest {
	
	List<IPLocation> locations;
	Lookup lookup;
	
	@Before
	public void setup() {
		locations = new ArrayList<IPLocation>();
		lookup = new Lookup(locations);		
	}
	
	@Test
	public void shouldGetCountryForASingleIpAdress() throws Exception {		
		locations.add(new IPLocation("139.130.4.5"));
		assertTrue(lookup.resolve().equals(resolvedLocations()));
	}

	private List<IPLocation> resolvedLocations() {
		List<IPLocation> locations = new ArrayList<IPLocation>();
		IPLocation location = new IPLocation("139.130.4.5");
		location.setCountry("Australia");
		locations.add(location);
		return locations;
	}
	

}
