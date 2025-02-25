package com.mafra.hexagonal.adapters.in.controller.mapper;

import com.mafra.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mafra.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper
{
	@Mapping(target = "address", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "isValidCPF", ignore = true)
	Customer toCustomer(CustomerRequest customerRequest);
}
