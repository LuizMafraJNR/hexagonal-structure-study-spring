package com.mafra.hexagonal.application.ports.in;

import com.mafra.hexagonal.application.core.domain.Customer;

import java.util.UUID;

public interface FindCustomerByIdInputPort {
    Customer find(UUID id);
}
