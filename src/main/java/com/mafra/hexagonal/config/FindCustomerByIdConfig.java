package com.mafra.hexagonal.config;

import com.mafra.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mafra.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.mafra.hexagonal.adapters.out.InsertCustomerAdapter;
import com.mafra.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mafra.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findAddressByZipCodeAdapter)
    {
        return new FindCustomerByIdUseCase(findAddressByZipCodeAdapter);
    }
}
