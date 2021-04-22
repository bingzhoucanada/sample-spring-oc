package com.binit.services.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.binit.services.customer.model.Customer;
import com.binit.services.customer.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerRepository repository;
	
	@PostMapping("/")
	public Customer add(@RequestBody Customer customer) {
		LOGGER.info("Customer add: {}", customer);
		return repository.save(customer);
	}
	
	@GetMapping("/{id}")
	public Customer findById(@PathVariable("id") String id) {
		LOGGER.info("customer find: id={}", id);
		return repository.findById(id).get();
	}
	
	@GetMapping("/")
	public Iterable<Customer> findAll() {
		LOGGER.info("customer find");
		return repository.findAll();
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Customer> findByDepartment(@PathVariable("departmentId") String departmentId) {
		LOGGER.info("Customer find: departmentId={}", departmentId);
		return repository.findByDepartmentId(departmentId);
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Customer> findByOrganization(@PathVariable("organizationId") String organizationId) {
		LOGGER.info("Customer find: organizationId={}", organizationId);
		return repository.findByOrganizationId(organizationId);
	}
	
}
