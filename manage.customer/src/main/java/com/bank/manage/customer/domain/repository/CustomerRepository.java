package com.bank.manage.customer.domain.repository;

import org.springframework.stereotype.Repository;
import com.bank.manage.customer.persistence.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {
	   
}
