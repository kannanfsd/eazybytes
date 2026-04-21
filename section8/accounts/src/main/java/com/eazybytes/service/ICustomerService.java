package com.eazybytes.service;

import com.eazybytes.dto.CustomerDetailsDto;

public interface ICustomerService {
    /**
     * Fetches the customer details for the given mobile number.
     * @param mobileNumber
     * @return
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
