package com.cts.springrest1.exception;

public class CustomerNotFound extends RuntimeException {
	
	public CustomerNotFound(String msg) {
		super(msg);
	}
	
	public CustomerNotFound() {
		
	}

}
