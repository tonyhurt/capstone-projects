package com.techelevator.npgeek;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6469103400417454398L;
	
	private String parkCode;

	public ParkNotFoundException(String parkCode, String message) {
		super(message);
		this.parkCode = parkCode;
	}

	public String getParkCode() {
		return this.parkCode;
	}

}
