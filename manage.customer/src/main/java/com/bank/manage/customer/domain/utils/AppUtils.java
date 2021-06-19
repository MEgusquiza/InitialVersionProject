package com.bank.manage.customer.domain.utils;

import org.springframework.beans.BeanUtils;

import com.bank.manage.customer.domain.dto.CustomerDto;
import com.bank.manage.customer.persistence.entity.Customer;

public class AppUtils {

    public static CustomerDto entityToDto(Customer customer) {
    	CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }
   
    public static Customer dtoToEntity(CustomerDto customerDto) {
    	Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
}
