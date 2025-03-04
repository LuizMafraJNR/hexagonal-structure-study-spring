package com.mafra.hexagonal.application.core.usecase;

import com.mafra.hexagonal.application.core.domain.Customer;
import com.mafra.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mafra.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mafra.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.mafra.hexagonal.application.ports.out.SendCpfForValidatioOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort
{

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidatioOutputPort sendCpfForValidatioOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidatioOutputPort sendCpfForValidatioOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidatioOutputPort = sendCpfForValidatioOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidatioOutputPort.send(customer.getCpf());
    }
}
