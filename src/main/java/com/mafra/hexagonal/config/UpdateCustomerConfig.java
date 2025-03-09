package com.mafra.hexagonal.config;

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
		FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
		FindCustomerByIdUseCase findCustomerByIdUseCase, UpdateCustomerOutputPort updateCustomerOutputPort)
	{
		return new UpdateCustomerUseCase(findAddressByZipCodeOutputPort, findCustomerByIdUseCase, updateCustomerOutputPort);
	}
}
