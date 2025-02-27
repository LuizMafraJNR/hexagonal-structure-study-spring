package com.mafra.hexagonal.config;

import com.mafra.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.mafra.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.mafra.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.mafra.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter)
    {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
