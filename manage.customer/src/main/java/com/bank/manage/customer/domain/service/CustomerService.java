package com.bank.manage.customer.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.manage.customer.domain.dto.CustomerDto;
import com.bank.manage.customer.domain.repository.CustomerRepository;
import com.bank.manage.customer.domain.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
	
   @Autowired
   private CustomerRepository repository;
   
   public Flux<CustomerDto> getCustomer(){
       return repository.findAll().map(AppUtils::entityToDto);
   }
   
   public Mono<CustomerDto> getCustomer(String id){
       return repository.findById(id).map(AppUtils::entityToDto);
   }
  
   public  Mono<CustomerDto> saveCustomer(Mono<CustomerDto> customerDtoMono){
	return   customerDtoMono.map(AppUtils::dtoToEntity)
	   .flatMap(repository::insert)
	   .map(AppUtils::entityToDto);
   }
   
   
 /*  public  Mono<CustomerDto> updateCustomer(Mono<CustomerDto> customerDtoMono, String id){ 
	   return repository.findById(id)
			  .flatMap(c -> customerDtoMono.map(AppUtils::dtoToEntity)
			  .doOnNext( e -> e.. (id) ) 
			   .flatMap(repository.save(null))
			   .map(AppUtils::entityToDto);
   }
   
  */
   
   
   public Mono<Void> deleteCustomer(String id){
	   
	   return repository.deleteById(id);
   }
   
}
