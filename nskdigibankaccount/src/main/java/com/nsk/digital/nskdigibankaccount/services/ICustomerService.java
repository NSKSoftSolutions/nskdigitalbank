package com.nsk.digital.nskdigibankaccount.services;

import com.nsk.digital.nskdigibankaccount.dto.CustomerDTO;
import com.nsk.digital.nskdigibankaccount.exceptions.CustomerAlreadyExist;
import com.nsk.digital.nskdigibankaccount.exceptions.CustomerNotFoundException;

import javax.security.auth.login.AccountNotFoundException;

public interface ICustomerService {
    public void onboardCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExist;

    public CustomerDTO getCustomerDetails(String mobileNumber) throws AccountNotFoundException;

    boolean updateCustomerDetails(CustomerDTO customerDTO) throws AccountNotFoundException;

    boolean deleteCustomerAccount(long accountNumber) throws AccountNotFoundException;
    //public boolean updateCustomerDetails(CustomerDTO customer);
}
