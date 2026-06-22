package com.nsk.digital.nskdigibank.accountservices.services;


import com.nsk.digital.nskdigibank.accountservices.dto.AccountsDTO;

public interface IAccountService {
    public void createAccount(AccountsDTO accountsDTO);
    //public boolean updateAccountDetails(AccountsDTO accounts) throws AccountNotFoundException;
}
