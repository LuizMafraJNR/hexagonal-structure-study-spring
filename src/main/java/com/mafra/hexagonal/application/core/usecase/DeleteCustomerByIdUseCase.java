package com.mafra.hexagonal.application.core.usecase;

import com.mafra.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mafra.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import java.util.Objects;
import java.util.UUID;

public class DeleteCustomerByIdUseCase
{

	private final FindCustomerByIdInputPort findCustomerByIdInputPort;
	private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

	public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort)
	{
		this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
	}

	public void delete(UUID id)
	{
		if (Objects.nonNull(findCustomerByIdInputPort.find(id)))
		{
			deleteCustomerByIdOutputPort.delete(id);
		}
	}
}
