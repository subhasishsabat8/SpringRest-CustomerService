package com.cts.springrest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.springrest1.entity.Customer;
import com.cts.springrest1.entity.User;
import com.cts.springrest1.repo.CustomerRepository;
import com.cts.springrest1.repo.UserRepository;

@SpringBootApplication
public class Springrest1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Springrest1Application.class, args);
		UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
		User user = new User();
		user.setActive(true);
		user.setId(1001);
		user.setUserName("admin");
		user.setPassword("admin");
		user.setRoles("ROLE_ADMIN");
		
		userRepository.save(user);
		
		CustomerRepository customerRepo = (CustomerRepository) ctx.getBean("customerRepository");
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Suresh");
		customer.setEmail("suresh@abc.in");
		customer.setContact("9090909090");
		customerRepo.save(customer);
	}

}
