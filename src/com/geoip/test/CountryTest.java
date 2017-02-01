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
		locations.add(new IPLocation("0.0.0.0"));
		assertTrue(lookup.resolve().equals(resolvedLocations()));
	}

	private List<IPLocation> resolvedLocations() {
		
		return null;
	}
	

}
