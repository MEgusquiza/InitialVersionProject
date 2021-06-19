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

	    @Id
	    private String id;
	    private String firstName;
	    private String lastName;
	    private Long phone;
	    private String email;
	    private String address;
	    private String state;
	    private String date;
	    
	
	
}
