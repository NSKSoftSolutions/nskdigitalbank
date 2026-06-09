package com.nsk.digital.nskdigibankaccount.services.impl;

import com.nsk.digital.nskdigibankaccount.dto.AccountsDTO;
import com.nsk.digital.nskdigibankaccount.dto.CustomerDTO;
import com.nsk.digital.nskdigibankaccount.entites.Accounts;
import com.nsk.digital.nskdigibankaccount.entites.Customer;
import com.nsk.digital.nskdigibankaccount.mappers.AccountMapper;
import com.nsk.digital.nskdigibankaccount.mappers.CustomerMapper;
import com.nsk.digital.nskdigibankaccount.repos.AccountsRepository;
import com.nsk.digital.nskdigibankaccount.repos.CustomerRepository;
import com.nsk.digital.nskdigibankaccount.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public void createAccount(AccountsDTO accountsDTO) {
        if (accountsDTO!=null){
            Accounts account=accountMapper.mapToAccount(accountsDTO);
            accountsRepository.save(account);
        }else{
            throw new RuntimeException("Account details are not valid");
        }
    }
}
