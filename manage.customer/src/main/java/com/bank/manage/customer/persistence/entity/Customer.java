package com.bank.manage.customer.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Implement lombok  by MongoDB Collections  

@Document(collection = "collCustomerManagement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer  {	   
	    @Id
	    private String id;
	    private String firstName;
	    private String lastName;
	    private String documentType ;
	    private String mail;
	    private Long   phone;
	    private String state;
	    
	
	
}
