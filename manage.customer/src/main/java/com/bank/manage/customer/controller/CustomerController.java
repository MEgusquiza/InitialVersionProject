package com.bank.manage.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import com.bank.manage.customer.domain.dto.CustomerDto;
import com.bank.manage.customer.domain.service.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
      
	@Autowired(required = true)
	private CustomerService service;
	
	
	@GetMapping
	Flux<CustomerDto> getCustomer(){
		return service.getCustomer();
   	}
	
	@GetMapping("/{id}")
	public Mono<CustomerDto> getCustomer(@PathVariable String id){
		return service.getCustomer(id);
   	}
	
	@PostMapping
	public Mono<CustomerDto> saveCustomer(@RequestBody Mono<CustomerDto> customerDtoMono){
  	return service.saveCustomer(customerDtoMono);
	}
	
	// falta update
	
	 @DeleteMapping("/delete/{id}")
	 public Mono<Void> deleteCustomer(@PathVariable String id){
		 return service.deleteCustomer(id);
	 }
}
