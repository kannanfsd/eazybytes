package com.eazybytes.mapper;

import com.eazybytes.dto.CustomerDetailsDto;
import com.eazybytes.dto.CustomerDto;
import com.eazybytes.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    // Entity to DTO
    CustomerDto mapToCustomerDto(Customer customer);
    // DTO to Entity creation
    Customer mapToCustomer(CustomerDto customerDto);
    // DTO to Entity updation
    void mapToCustomer(CustomerDto customerDto, @MappingTarget Customer customer);

    CustomerDetailsDto mapToCustomerDetailsDto(Customer customer);

}
