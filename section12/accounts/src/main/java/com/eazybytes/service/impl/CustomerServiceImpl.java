package com.eazybytes.service.impl;

import com.eazybytes.dto.CardsDto;
import com.eazybytes.dto.CustomerDetailsDto;
import com.eazybytes.dto.LoansDto;
import com.eazybytes.entity.Accounts;
import com.eazybytes.entity.Customer;
import com.eazybytes.exception.ResourceNotFoundException;
import com.eazybytes.mapper.AccountsMapper;
import com.eazybytes.mapper.CustomerMapper;
import com.eazybytes.repository.AccountsRepository;
import com.eazybytes.repository.CustomerRepository;
import com.eazybytes.service.ICustomerService;
import com.eazybytes.service.client.CardsFeignClient;
import com.eazybytes.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;
    private CustomerMapper customerMapper;
    private AccountsMapper accountsMapper;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDetailsDto customerDetailsDto = customerMapper.mapToCustomerDetailsDto(customer);
        customerDetailsDto.setAccountsDto(accountsMapper.mapToAccountsDto(accounts));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if(null != loansDtoResponseEntity) {
            customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        }

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if(null != cardsDtoResponseEntity) {
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        }
        return customerDetailsDto;
    }
}
