package com.mafra.hexagonal.adapters.in.controller;

import com.mafra.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.mafra.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mafra.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.mafra.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.mafra.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mafra.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mafra.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import java.util.Objects;
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

	@Autowired
	private UpdateCustomerInputPort updateCustomerInputPort;

	@Autowired
	private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

	@PostMapping
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

	@PutMapping({"/{id}"})
	public ResponseEntity<Void> update(@PathVariable("id") UUID id, @RequestBody @Valid CustomerRequest customerRequest)
	{
		var customer = customerMapper.toCustomer(customerRequest);
		customer.setId(id);
		updateCustomerInputPort.update(customer, customerRequest.getZipCode());
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> delete(@PathVariable("id") UUID id)
	{
		if (Objects.nonNull(findCustomerByIdInputPort.find(id)))
		{
			deleteCustomerByIdInputPort.delete(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
