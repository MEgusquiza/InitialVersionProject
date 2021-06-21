package com.bank.manage.customer.controller;

import org.springframework.web.bind.annotation.*;
import com.bank.manage.customer.domain.service.CustomerService;
import com.bank.manage.customer.domain.service.CustomerServiceImpl;
import com.bank.manage.customer.persistence.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/customer")
public class CustomerController {
      
	@Autowired
	private CustomerServiceImpl  customerServiceImpl;
		
	@GetMapping("/{id}")
	public ResponseEntity<Mono<Customer>> getCustomer(@PathVariable("id") String id) {
		return ResponseEntity.ok(customerServiceImpl.getByIdCustomer(id));
	}
	
   @GetMapping(value="/customers",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomers() {
        return customerServiceImpl.getAllCustomer();
    }

	@PostMapping("/save")
	public ResponseEntity<Mono<Customer>> createCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerServiceImpl.createCustomer(customer) );
	}
	
    @PutMapping("/update/{id}")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
        //logger.debug("Updating User with user-id = {}.", id);
        return customerServiceImpl.updateCustomer(customer, id);
    }
    
	 @PostMapping("/delete/{id}")
    public Mono<Void> deleteCustomer(@PathVariable("id") String id){
        return customerServiceImpl.deleteByIdCustomer(id);
    }
    
}
