package com.mafra.hexagonal.application.core.usecase;

import com.mafra.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.mafra.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mafra.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import java.util.Objects;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort
{

	private final FindCustomerByIdInputPort findCustomerByIdInputPort;
	private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

	public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort)
	{
		this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
	}

	@Override
	public void delete(UUID id)
	{
		if (Objects.nonNull(findCustomerByIdInputPort.find(id)))
		{
			deleteCustomerByIdOutputPort.delete(id);
		}
	}
}
