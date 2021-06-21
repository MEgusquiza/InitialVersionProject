package com.bank.manage.customer.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bank.manage.customer.domain.repository.CustomerRepository;
import com.bank.manage.customer.persistence.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

	   @Autowired
	   private CustomerRepository customerRepository;
	   
	   
		public Mono<Customer> getByIdCustomer(String id) {
			return customerRepository.findById(id)
					.switchIfEmpty(Mono.error(new Exception("No Customer found with Id: " + id)));
		}
	   
	    public Flux<Customer> getAllCustomer() {
	        long start = System.currentTimeMillis();
	        Flux<Customer> customers = customerRepository.findAll() ;
	        long end = System.currentTimeMillis();
	        System.out.println("customerRepositoryTotal execution time : " + (end - start));
	        return customers;
	    }
	    
	    public Mono<Customer> createCustomer(Customer customer) {
	        return customerRepository.insert(customer);
	    }   
	    
		public Mono<Customer> updateCustomer(Customer customer , String id) {
			return getByIdCustomer(id).doOnNext(
	                  findCustomer -> {
	                	  findCustomer.setFirstName(customer.getFirstName());
	                	  findCustomer.setLastName(customer.getLastName());
	                	  findCustomer.setDocumentType(customer.getDocumentType());
	                	  findCustomer.setMail(customer.getMail());
	                	  findCustomer.setPhone(customer.getPhone());
	                	  findCustomer.setState(customer.getState());
	                	  customerRepository.save(findCustomer).subscribe();
	                	  }).switchIfEmpty(Mono.error(new Exception("No Customer found.... " + id)));
		}
	   
	    public Mono<Void> deleteByIdCustomer(String id){
	        return customerRepository.deleteById(id);
	    }

	    public Mono<Void> deleteAllCustomer() {
	        return customerRepository.deleteAll();
	    }
	    
	/*    public Mono<ServerResponse> createCustomer(ServerRequest serverRequest){
	        Mono<Customer> studentMono = serverRequest.bodyToMono(Customer.class);
	        return  studentMono.flatMap(student ->
	                 ServerResponse.status(HttpStatus.CREATED)
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .body(customerRepository.save(student),Customer.class) );
	    }
*/
	    
	    
	    
}
