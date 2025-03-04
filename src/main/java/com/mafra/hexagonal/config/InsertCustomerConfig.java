package com.mafra.hexagonal.config;

import com.mafra.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mafra.hexagonal.adapters.out.InsertCustomerAdapter;
import com.mafra.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.mafra.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mafra.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.mafra.hexagonal.application.ports.out.SendCpfForValidatioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidatioOutputPort sendCpfForValidatioOutputPort)
    {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidatioOutputPort);
    }
}
