package com.mafra.hexagonal.adapters.out;

import com.mafra.hexagonal.adapters.out.repository.CustomerRepository;
import com.mafra.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.mafra.hexagonal.application.core.domain.Customer;
import com.mafra.hexagonal.application.ports.out.FindCustiomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class FindCustomerByIdAdapter implements FindCustiomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(UUID id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity
                .map(entity -> customerEntityMapper.toCostumer(entity));
    }
}
