package com.nsk.digital.nskdigibank.accountservices.services;


import com.nsk.digital.nskdigibank.accountservices.dto.CustomerDTO;
import com.nsk.digital.nskdigibank.accountservices.exceptions.CustomerAlreadyExist;

import javax.security.auth.login.AccountNotFoundException;

public interface ICustomerService {
    public void onboardCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExist;

    public CustomerDTO getCustomerDetails(String mobileNumber) throws AccountNotFoundException;

    boolean updateCustomerDetails(CustomerDTO customerDTO) throws AccountNotFoundException;

    boolean deleteCustomerAccount(long accountNumber) throws AccountNotFoundException;
    //public boolean updateCustomerDetails(CustomerDTO customer);
}
