package com.nsk.digital.nskdigibankaccount.mappers;

import com.nsk.digital.nskdigibankaccount.dto.AccountsDTO;
import com.nsk.digital.nskdigibankaccount.entites.Accounts;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {


    public Accounts mapToAccount(AccountsDTO accountsDTO){
        Accounts accounts=new Accounts();
        accounts.setAccountNumber(accountsDTO.getAccountNumber());
        accounts.setAccountType(accountsDTO.getAccountType());
        accounts.setBranchAddress(accountsDTO.getBranchAddress());
        return accounts;
    }
    public AccountsDTO mapToAccountDto(Accounts accounts){
        AccountsDTO accountsDTO=new AccountsDTO();
        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        accountsDTO.setAccountType(accounts.getAccountType());
        accountsDTO.setBranchAddress(accounts.getBranchAddress());
       return accountsDTO;
    }

}
