package com.mafra.hexagonal.application.core.usecase;

import com.mafra.hexagonal.application.core.domain.Customer;
import com.mafra.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mafra.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
