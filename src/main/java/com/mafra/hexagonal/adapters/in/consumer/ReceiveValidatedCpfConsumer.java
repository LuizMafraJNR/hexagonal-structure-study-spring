package com.mafra.hexagonal.adapters.in.consumer;

import com.mafra.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.mafra.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.mafra.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "aacs")
    public void receive(CustomerMessage customerMessage){
        var custoomer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(custoomer,customerMessage.getZipCode());
    }
}
