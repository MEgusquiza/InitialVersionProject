package com.bank.manage.customer.domain.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String documentType ;
    private String email;
    private Long   phone;
    private String state;
    
}
