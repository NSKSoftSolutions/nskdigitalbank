package com.nsk.digital.nskdigibankaccount.services.impl;

import com.nsk.digital.nskdigibankaccount.constants.CustomerConstants;
import com.nsk.digital.nskdigibankaccount.dto.CustomerDTO;
import com.nsk.digital.nskdigibankaccount.dto.ResponseDTO;
import com.nsk.digital.nskdigibankaccount.entites.Accounts;
import com.nsk.digital.nskdigibankaccount.entites.Customer;
import com.nsk.digital.nskdigibankaccount.enums.AccountType;
import com.nsk.digital.nskdigibankaccount.enums.Branch;
import com.nsk.digital.nskdigibankaccount.exceptions.CustomerAlreadyExist;
import com.nsk.digital.nskdigibankaccount.exceptions.CustomerNotFoundException;
import com.nsk.digital.nskdigibankaccount.mappers.AccountMapper;
import com.nsk.digital.nskdigibankaccount.mappers.CustomerMapper;
import com.nsk.digital.nskdigibankaccount.repos.AccountsRepository;
import com.nsk.digital.nskdigibankaccount.repos.CustomerRepository;
import com.nsk.digital.nskdigibankaccount.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountsRepository accountRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public void onboardCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExist {

        if (customerDTO != null) {
            validateCustomer(customerDTO);
            Customer customer = customerMapper.mapToCustomer(customerDTO);
            customer.setCreatedBy("NSK Digital BANK");
            customer.setCreatedAt(LocalDateTime.now());
            customerRepository.save(customer);
            Accounts account = createAccount();
            account.setCustomerId(customer.getCustomerId());
            accountRepository.save(account);
        } else {
            throw new RuntimeException(CustomerConstants.CUSTOMER_DETAILS_NOT_VALID);
        }
    }

    @Override
    public CustomerDTO getCustomerDetails(String mobileNumber) throws AccountNotFoundException {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new CustomerNotFoundException("Customer with mobile number " + mobileNumber + " not found"));
        Accounts account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new AccountNotFoundException("Account not found for CustomerId " + customer.getCustomerId()));

        CustomerDTO customerDTO = customerMapper.mapToCustomerDTO(customer);
        customerDTO.setAccount(account);
        return customerDTO;
    }

    @Override
    public boolean updateCustomerDetails(CustomerDTO customerDTO) throws AccountNotFoundException {
        boolean isUpdated = false;
        Accounts accounts = accountRepository.findById(customerDTO.getAccount().getAccountNumber()).orElseThrow(() -> new AccountNotFoundException("Account Not Found for Account_Number" + customerDTO.getAccount().getAccountNumber()));
        if (accounts != null) {

            long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found for CustomerId" + customerId));
            if (customer != null) {
                Accounts account = customerDTO.getAccount();
                account.setCustomerId(customerId);
                account.setBranchAddress(customerDTO.getAccount().getBranchAddress());
                account.setAccountType(customerDTO.getAccount().getAccountType());
                account.setUpdatedAt(LocalDateTime.now());
                account.setUpdatedBy("Navab Sajjad Alikhan");
                accountRepository.save(account);

                customer.setName(customerDTO.getName());
                customer.setEmail(customerDTO.getEmail());
                customer.setMobileNumber(customerDTO.getMobileNumber());
                customer.setUpdatedAt(LocalDateTime.now());
                customer.setUpdatedBy("Navab Sajjad Alikhan");
                customerRepository.save(customer);

            }
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCustomerAccount(long accountNumber) throws AccountNotFoundException {
        boolean isDeleted = false;
        Accounts account = accountRepository.findById(accountNumber).orElseThrow(() -> new AccountNotFoundException("Account Not Found for Account_Number" + accountNumber));
        if (account != null) {
            Customer customer = customerRepository.findById(account.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found for CustomerId" + account.getCustomerId()));
            customerRepository.delete(customer);
            accountRepository.delete(account);
            isDeleted = true;
        }
        return isDeleted;
    }

    private Accounts createAccount() {
        Accounts account = new Accounts();
        account.setAccountType(AccountType.SAVINGS.name());
        account.setAccountNumber(new Random().nextLong(999999999));
        account.setBranchAddress(Branch.TALUPULA.name());
        account.setCreatedBy("NSK Digital BANK");
        account.setCreatedAt(LocalDateTime.now());
        return account;
    }

    private void validateCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExist {
        if (customerDTO == null) {
            throw new RuntimeException(CustomerConstants.CUSTOMER_DETAILS_NOT_VALID);
        } else {
            Optional<Customer> customer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
            if (customer.isPresent()) {
                throw new CustomerAlreadyExist("Customer with mobile number " + customerDTO.getMobileNumber() + " already exist");
            }
        }
    }
}