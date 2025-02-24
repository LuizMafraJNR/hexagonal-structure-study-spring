package com.mafra.hexagonal.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "customers")
public class CustomerEntity {
    @Id
    private UUID id;
    private String name;
    private AddressEntity address;
    private String cpf;
    private Boolean isValidCPF;
}
