package com.mafra.hexagonal.application.ports.in;

import com.mafra.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort
{
	void insert(Customer customer, String zipCode);
}
