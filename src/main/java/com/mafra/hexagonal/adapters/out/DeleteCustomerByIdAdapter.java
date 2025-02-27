package com.mafra.hexagonal.adapters.out;

import com.mafra.hexagonal.adapters.out.repository.CustomerRepository;
import com.mafra.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort
{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void delete(UUID id)
	{
		customerRepository.deleteById(id);
	}
}
