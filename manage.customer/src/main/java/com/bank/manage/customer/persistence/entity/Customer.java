package com.bank.manage.customer.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Document(collection = "tbk_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer  {
	
	///   private static final long serialVersionUID = 1L;
	   
	   
	    @Id
	    private String id;
	    private String firstName;
	    private String lastName;
	    private String documentType ;
	    private String mail;
	    private Long   phone;
	    private String state;
	    
	
	
}
