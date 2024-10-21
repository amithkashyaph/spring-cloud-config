package com.project.accounts.service.impl;

import com.project.accounts.constants.AccountConstants;
import com.project.accounts.dto.AccountDto;
import com.project.accounts.dto.CustomerDto;
import com.project.accounts.entity.Account;
import com.project.accounts.entity.Customer;
import com.project.accounts.exception.CustomerAlreadyExistsException;
import com.project.accounts.exception.ResourceNotFoundException;
import com.project.accounts.mapper.AccountMapper;
import com.project.accounts.mapper.CustomerMapper;
import com.project.accounts.repository.AccountRepository;
import com.project.accounts.repository.CustomerRepository;
import com.project.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {


    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        Optional<Customer> customerExists = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(customerExists.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with the mobile number " + customerDto.getMobileNumber());
        }

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        Customer savedCustomer = customerRepository.save(customer);

        accountRepository.save(createNewAccount(savedCustomer));

    }

}
