package com.cts.springrest1.exception;

import java.util.Date;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cts.springrest1.controller.CustomerController;

@ControllerAdvice
public class GlobalException {
	
	Logger logger = LoggerFactory.getLogger(GlobalException.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorStatus> exceptionMsg(HttpServletRequest r, Exception e) {
		//System.out.println("Global Exception Handled");
		logger.error("Global Exception Handled");
		ErrorStatus errorStatus = new ErrorStatus(new Date(), e.getMessage(), r.getRequestURI());
		ResponseEntity<ErrorStatus> responseEntity = new ResponseEntity<>(errorStatus, HttpStatus.NOT_FOUND);
		return responseEntity;

	}

	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<ErrorStatus> exceptionMsg1(HttpServletRequest r, Exception e) {
		//System.out.println("Customer Not Found Exception Handled");
		logger.error("Customer Not Found Exception Handled");
		ErrorStatus errorStatus = new ErrorStatus(new Date(), e.getMessage(), r.getRequestURI());
		ResponseEntity<ErrorStatus> responseEntity = new ResponseEntity<>(errorStatus, HttpStatus.NOT_FOUND);
		return responseEntity;

	}
}
