package com.cts.springrest1.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.springrest1.entity.Customer;
import com.cts.springrest1.service.CustomerService;

@RestController
@Validated
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping
	public ResponseEntity getCustomers() {
		logger.info("Getting all Customers");
		logger.debug("Getting all Customers");
		return customerService.getCustomers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		logger.info("Getting Customer by Id");
		logger.debug("Getting Customer by Id");
		return customerService.getCustomerById(id);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam String name) {
		logger.info("Getting Customer by name");
		logger.debug("Getting Customer by name");
		return customerService.getCustomerByName(name);
	}

	@PostMapping
	public Customer insertCustomer(@Valid @RequestBody Customer c) {
		logger.info("Posting Customer");
		logger.debug("Posting Customer");
		return customerService.insertCustomer(c);
	}

	@PutMapping
	public Customer updateCustomer(@Valid @RequestBody Customer c) {
		logger.info("Updating Customer");
		logger.debug("Updating Customer");
		return customerService.updateCustomer(c);
	}

	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		logger.info("Deleting Customer by Id");
		logger.debug("Deleting Customer by Id");
		return customerService.deleteCustomer(id);
	}

}
