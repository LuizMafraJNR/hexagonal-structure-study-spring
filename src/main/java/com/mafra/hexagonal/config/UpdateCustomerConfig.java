package com.mafra.hexagonal.config;

import com.mafra.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mafra.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mafra.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mafra.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.mafra.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mafra.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig
{
	@Bean
	public UpdateCustomerUseCase updateCustomerUseCase(
		FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
		FindCustomerByIdUseCase findCustomerByIdUseCase, UpdateCustomerAdapter updateCustomerAdapter)
	{
		return new UpdateCustomerUseCase(findAddressByZipCodeAdapter, findCustomerByIdUseCase, updateCustomerAdapter);
	}
}
