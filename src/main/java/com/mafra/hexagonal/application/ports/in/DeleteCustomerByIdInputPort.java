package com.mafra.hexagonal.application.ports.in;

import java.util.UUID;

public interface DeleteCustomerByIdInputPort
{
	void delete(UUID id);
}
