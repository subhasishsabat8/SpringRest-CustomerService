package com.cts.springrest1.exception;

import java.util.Date;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorStatus> exceptionMsg(HttpServletRequest r, Exception e) {
		System.out.println("Global Exception Handled");
		ErrorStatus errorStatus = new ErrorStatus(new Date(), e.getMessage(), r.getRequestURI());
		ResponseEntity<ErrorStatus> responseEntity = new ResponseEntity<>(errorStatus, HttpStatus.NOT_FOUND);
		return responseEntity;

	}

	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<ErrorStatus> exceptionMsg1(HttpServletRequest r, Exception e) {
		System.out.println("Customer Not Found Exception Handled");
		ErrorStatus errorStatus = new ErrorStatus(new Date(), e.getMessage(), r.getRequestURI());
		ResponseEntity<ErrorStatus> responseEntity = new ResponseEntity<>(errorStatus, HttpStatus.NOT_FOUND);
		return responseEntity;

	}
}
