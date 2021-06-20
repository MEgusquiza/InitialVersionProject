package com.bank.manage.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import com.bank.manage.customer.domain.service.CustomerService;
import com.bank.manage.customer.persistence.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/customer")
public class CustomerController {
      
	//Inicializando Logger.
   // Logger final privado Logger = LoggerFactory. getLogger ( clase CustomerController. ) ; 

	
	@Autowired
	private CustomerService  customerService;
	
	
	/*@GetMapping("/all")
	Flux<Customer> getAllCustomer(){
	//	return customerService.f;
   	}*/
	
	/*@PutMapping("/customer")
	public ResponseEntity<Mono<Customer>> saveAuthor(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerservice.saveCustomer(customer) );
	}
	*/
	@GetMapping("/{id}")
	public ResponseEntity<Mono<Customer>> getCustomer(@PathVariable("id") String id) {
		return ResponseEntity.ok(customerService.findByCustomer(id));
	}
	
	
/*	@GetMapping("/{id}")
	public Mono<ResponseEntity<Customer>> getCustomerById(
			           @PathVariable("id") String customerId){
		return customerService.findByCustomer(customerId)    
	               .map(saveCustomer -> ResponseEntity
		           .ok(saveCustomer). customerService.findByCustomer(id));
	}
	*/
	
/*	@GetMapping("/{id}")
	public Mono<CustomerDto> getCustomer(@PathVariable String id){
		return service.getCustomer(id);
   	}
/*
	@PostMapping("/save")
	public Mono<CustomerDto> saveCustomer(@RequestBody Mono<CustomerDto> customerDtoMono){
  	return service.saveCustomer(customerDtoMono);
	}
*/	
/*	@PostMapping("/save")
	public ResponseEntity<Mono<Customer>> saveAuthors(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.saveAuthor(customer));
	}
	*/
	// falta update
	
/*	 @DeleteMapping("/delete/{id}")
	 public Mono<Void> deleteCustomer(@PathVariable String id){
		 return service.deleteCustomer(id);
	 }*/
}
