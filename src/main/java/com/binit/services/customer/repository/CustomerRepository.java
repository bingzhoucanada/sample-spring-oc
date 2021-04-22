package com.binit.services.customer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.binit.services.customer.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	
	List<Customer> findByDepartmentId(String departmentId);
	List<Customer> findByOrganizationId(String organizationId);
	
}
