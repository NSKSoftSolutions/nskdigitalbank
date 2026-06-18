package com.nsk.digital.nskdigibank.accountservices.services.impl;

import com.nsk.digital.nskdigibank.accountservices.dto.AccountsDTO;
import com.nsk.digital.nskdigibank.accountservices.entites.Accounts;
import com.nsk.digital.nskdigibank.accountservices.mappers.AccountMapper;
import com.nsk.digital.nskdigibank.accountservices.mappers.CustomerMapper;
import com.nsk.digital.nskdigibank.accountservices.repos.AccountsRepository;
import com.nsk.digital.nskdigibank.accountservices.repos.CustomerRepository;
import com.nsk.digital.nskdigibank.accountservices.services.IAccountService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
