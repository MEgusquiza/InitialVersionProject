package com.bank.manage.customer.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.manage.customer.domain.repository.CustomerRepository;
import com.bank.manage.customer.persistence.entity.Customer;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CustomerService {
	
   @Autowired
   private CustomerRepository customerRepository;
   
      
  /* public Flux<CustomerDto> getCustomer(){
       return repository.findAll().map(AppUtils::entityToDto);
   }
    */ 
 /*  public Mono<CustomerDto> getCustomer(String id){
       return repository.findById(id).map(AppUtils::entityToDto);
   }*/
   

  /* public  Mono<Customer> saveCustomer(Mono<Customer> customerMono){
	return   customerMono.map(AppUtils::dtoToEntity)
	   .flatMap(repository::insert)
	   .map(AppUtils::entityToDto);
   }
   */
   
	/*public Mono<Customer> saveCustomer(Customer customer) {
		if (StringUtils.isEmpty(customer.getId())) {
			return customerRepository.findByIdAndDeleteIsFalse(customer.getId())
			                       .switchIfEmpty(Mono.error(new Exception("No Author found with Id: " + customer.getId())))
			                       .doOnSuccess(customer1 -> {
			                    	   customer1 = updateCustomer(customer, customer1);
				                       authorRepository.save(customer1)
				                                       .subscribe();
			                       });
		}
		return repository.save(customer);
	}
   */
   
	public Mono<Customer> findByCustomer(String id) {
		return customerRepository.findById(id)
				.switchIfEmpty(Mono.error(new Exception("No Author found with Id: " + id)));
	}
   
	
/*	public Mono<Customer> findByCustomer(String id) {
		return customerRepository.findById(id)
				.switchIfEmpty(Mono.error(new Exception("No Author found with Id: " + id)));
	}
   
	public Flux<Customer> findByCustomerName(String name) {
		return customerRepository.findByFirstName(name)
				.switchIfEmpty(Flux.error(new Exception("No Author found with Id: " +name)));
	}
   */
 /*  public  Mono<CustomerDto> updateCustomer(Mono<CustomerDto> customerDtoMono, String id){ 
	   return repository.findById(id)
			  .flatMap(c -> customerDtoMono.map(AppUtils::dtoToEntity)
			  .doOnNext( e -> e.. (id) ) 
			   .flatMap(repository.save(null))
			   .map(AppUtils::entityToDto);
   }
   
  */
   
 /*  
   public Mono<Void> deleteCustomer(String id){
	   
	   return repository.deleteById(id);
   }
   */
}
