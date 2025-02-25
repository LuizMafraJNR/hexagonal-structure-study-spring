package com.mafra.hexagonal.adapters.in.controller;

import com.mafra.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.mafra.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mafra.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController
{
	@Autowired
	private InsertCustomerInputPort insertCustomerInputPort;

	@Autowired
	private CustomerMapper customerMapper;

	@PutMapping
	public ResponseEntity<Void> insert(@RequestBody  @Valid CustomerRequest customerRequest)
	{
		var customer = customerMapper.toCustomer(customerRequest);
		insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
		return ResponseEntity.ok().build();
	}
}
