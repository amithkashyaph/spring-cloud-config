package com.project.accounts.service;

import com.project.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     *
     * @param customerDto - CustomerDto object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - String
     * @return CustomerDto
     */
    CustomerDto fetchCustomerByMobileNumber(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return boolean if the updation was successful or not
     */
    boolean updateAccountDetails(CustomerDto customerDto);


    /**
     *
     * @param mobileNumber
     */
    boolean deleteAccountByMobileNumber(String mobileNumber);
}
