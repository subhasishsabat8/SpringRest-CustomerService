package com.cts.springrest1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.springrest1.entity.Customer;
import com.cts.springrest1.exception.CustomerNotFound;
import com.cts.springrest1.repo.CustomerRepository;

@Service

public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public ResponseEntity getCustomers() {
		List<Customer> customerList = customerRepository.findAll();
		return ResponseEntity.ok(customerList);
	}
	
	public ResponseEntity<Customer> getCustomerById(Long id) {
		// Customer c1 = new Customer();
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			Customer c1 = customer.get();
			return ResponseEntity.ok(c1);
		} else {
			throw new CustomerNotFound("Customer Not Found");
		}
	}
	
	public ResponseEntity<List<Customer>> getCustomerByName(String name) {
		// Customer c1 = new Customer();
		Optional customer = customerRepository.findByName(name);
		if (customer.isPresent()) {
			List<Customer> c1 = (List<Customer>) customer.get();
			return ResponseEntity.ok(c1);
		} else {
			throw new CustomerNotFound("Customer Not Found");
		}
	}
	
	public Customer insertCustomer(@RequestBody Customer c) {
		return customerRepository.save(c);
	}
	
	public Customer updateCustomer(@RequestBody Customer c) {
		c.setEmail("suresh1@abc.in");
		return customerRepository.save(c);
	}
	
	public String deleteCustomer(@PathVariable Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			Customer c1 = customer.get();
			customerRepository.delete(c1);
			return "Successfully deleted Customer with id "+ id;
		} else {
			throw new CustomerNotFound("Customer Not Found");
		}
	}

}
