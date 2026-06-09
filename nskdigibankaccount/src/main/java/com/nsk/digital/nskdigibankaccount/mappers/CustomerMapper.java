package com.nsk.digital.nskdigibankaccount.mappers;

import com.nsk.digital.nskdigibankaccount.dto.CustomerDTO;
import com.nsk.digital.nskdigibankaccount.entites.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO mapToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }

    public Customer mapToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        return customer;
    }


}
