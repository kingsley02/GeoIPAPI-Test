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
		List<IPLocation> expected = new ArrayList<IPLocation>();
		expected.add(australia());
		assertTrue(lookup.resolve().equals(expected));
	}

	
	@Test
	public void shouldGetCountryForMultipleIpAdresses() throws Exception {	
		
		locations.add(new IPLocation("139.130.4.5"));
		locations.add(new IPLocation("209.191.88.254"));
		List<IPLocation> expected = new ArrayList<IPLocation>();
		expected.add(australia());
		expected.add(usa());
		assertTrue(lookup.resolve().equals(expected));
		System.out.println("");
	}
	
	
	private IPLocation australia() {		
		IPLocation location = new IPLocation("139.130.4.5");
		location.setCountry("Australia");		
				
		return location;
	}
	
	private IPLocation usa() {		
		IPLocation location = new IPLocation("209.191.88.254");
		location.setCountry("United States");					
		
		return location;
	}
	

}
