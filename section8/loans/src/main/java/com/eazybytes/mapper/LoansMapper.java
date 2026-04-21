package com.eazybytes.mapper;

import com.eazybytes.dto.LoansDto;
import com.eazybytes.entity.Loans;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LoansMapper {
    // Entity to DTO
    LoansDto mapToLoansDto(Loans loans);

    // DTO to Entity create
    Loans mapToLoans(LoansDto loansDto);

    // DTO to Entity update
    void mapToLoans(LoansDto loansDto, @MappingTarget Loans loans);
}
