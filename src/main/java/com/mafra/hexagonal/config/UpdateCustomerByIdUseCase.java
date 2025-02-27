package com.mafra.hexagonal.config;

import com.mafra.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mafra.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.mafra.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mafra.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mafra.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerByIdUseCase {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       UpdateCustomerAdapter updateCustomerUseCase)
    {
        return new UpdateCustomerUseCase(findAddressByZipCodeAdapter, findCustomerByIdUseCase, updateCustomerUseCase);
    }
}
