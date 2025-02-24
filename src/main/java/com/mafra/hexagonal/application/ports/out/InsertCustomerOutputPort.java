package com.mafra.hexagonal.application.ports.out;

import com.mafra.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
