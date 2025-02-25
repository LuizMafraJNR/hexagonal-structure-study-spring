package com.mafra.hexagonal.application.ports.out;

import com.mafra.hexagonal.application.core.domain.Customer;
import java.util.Optional;
import java.util.UUID;

public interface FindCustiomerByIdOutputPort
{
	Optional<Customer> find(UUID id);
}
