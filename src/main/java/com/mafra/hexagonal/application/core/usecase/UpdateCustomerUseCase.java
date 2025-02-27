package com.mafra.hexagonal.application.core.usecase;

import com.mafra.hexagonal.application.core.domain.Customer;
import com.mafra.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mafra.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.mafra.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mafra.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import java.util.Objects;
import java.util.UUID;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort
{

	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
	private final FindCustomerByIdInputPort findCustomerByIdInputPort;
	private final UpdateCustomerOutputPort updateCustomerOutputPort;

	public UpdateCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
		FindCustomerByIdInputPort findCustomerByIdInputPort, UpdateCustomerOutputPort updateCustomerOutputPort)
	{
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
		this.updateCustomerOutputPort = updateCustomerOutputPort;
	}

	@Override
	public void update(Customer customer, String zipCode)
	{
			if (Objects.nonNull(findCustomerByIdInputPort.find(customer.getId()))){
				var address = findAddressByZipCodeOutputPort.find(zipCode);
				customer.setAddress(address);
				updateCustomerOutputPort.update(customer);
			}
	}

}
