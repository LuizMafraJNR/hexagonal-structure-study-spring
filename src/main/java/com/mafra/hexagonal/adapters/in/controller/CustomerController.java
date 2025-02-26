package com.mafra.hexagonal.adapters.in.controller;

import com.mafra.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.mafra.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mafra.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.mafra.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mafra.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController
{
	@Autowired
	private InsertCustomerInputPort insertCustomerInputPort;

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private FindCustomerByIdInputPort findCustomerByIdInputPort;

	@PutMapping
	public ResponseEntity<Void> insert(@RequestBody  @Valid CustomerRequest customerRequest)
	{
		var customer = customerMapper.toCustomer(customerRequest);
		insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
		return ResponseEntity.ok().build();
	}

	@GetMapping({"/{id}"})
	public ResponseEntity<CustomerResponse> findById(@PathVariable("id") UUID id)
	{
		var customer = findCustomerByIdInputPort.find(id);
		var customerResponse = customerMapper.toCustomerResponse(customer);
		return ResponseEntity.ok().body(customerResponse);
	}
}
