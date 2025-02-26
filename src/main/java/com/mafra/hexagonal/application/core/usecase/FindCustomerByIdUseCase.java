package com.mafra.hexagonal.application.core.usecase;

import com.mafra.hexagonal.application.core.domain.Customer;
import com.mafra.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mafra.hexagonal.application.ports.out.FindCustiomerByIdOutputPort;
import java.util.UUID;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort
{
	public final FindCustiomerByIdOutputPort findCustiomerByIdOutputPort;

	public FindCustomerByIdUseCase(FindCustiomerByIdOutputPort findCustiomerByIdOutputPort)
	{
		this.findCustiomerByIdOutputPort = findCustiomerByIdOutputPort;
	}

	@Override
	public Customer find(UUID id){
		return findCustiomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
	}
}

