package com.mafra.hexagonal.adapters.out.repository.mapper;

import com.mafra.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mafra.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper
{
	CustomerEntity toCustomerEntity(Customer customer);
	Customer toCostumer(CustomerEntity customerEntity);
}
