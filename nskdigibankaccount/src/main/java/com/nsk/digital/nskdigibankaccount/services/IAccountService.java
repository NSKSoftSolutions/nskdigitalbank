package com.nsk.digital.nskdigibankaccount.services;

import com.nsk.digital.nskdigibankaccount.dto.AccountsDTO;

import javax.security.auth.login.AccountNotFoundException;

public interface IAccountService {
    public void createAccount(AccountsDTO accountsDTO);
    //public boolean updateAccountDetails(AccountsDTO accounts) throws AccountNotFoundException;
}
