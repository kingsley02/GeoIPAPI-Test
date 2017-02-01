package com.geoip.main;

import java.io.IOException;

public class LookupException extends Exception {

	public LookupException(String message, Exception e) {
		super(message, e);
	}

}
