package com.mafra.hexagonal.application.core.domain;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCPF;

    public Customer() {
        this.isValidCPF = false;
    }

    public Customer(UUID id, String name, Address address, String cpf, Boolean isValidCPF) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCPF = isValidCPF;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidCPF() {
        return isValidCPF;
    }

    public void setValidCPF(Boolean validCPF) {
        isValidCPF = validCPF;
    }
}
