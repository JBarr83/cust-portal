package com.jbarr.custportal.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jbarr.custportal.model.Customer;
 

 
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);

	Customer findOne(long id);
}
