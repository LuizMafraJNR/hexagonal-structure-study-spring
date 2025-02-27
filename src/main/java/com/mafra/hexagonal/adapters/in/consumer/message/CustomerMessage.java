package com.mafra.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {
    private UUID id;
    private String name;
    private String zipCode;
    private String cpf;
    private Boolean isValidCpf;
}
