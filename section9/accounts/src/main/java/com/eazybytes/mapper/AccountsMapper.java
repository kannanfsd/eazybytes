package com.eazybytes.mapper;

import com.eazybytes.dto.AccountsDto;
import com.eazybytes.entity.Accounts;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountsMapper {

    AccountsDto mapToAccountsDto(Accounts accounts);

    Accounts mapToAccounts(AccountsDto accountsDto);

    void mapToAccounts(AccountsDto accountsDto, @MappingTarget Accounts accounts);
}
