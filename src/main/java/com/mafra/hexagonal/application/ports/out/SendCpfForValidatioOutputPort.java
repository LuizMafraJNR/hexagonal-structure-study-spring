package com.mafra.hexagonal.application.ports.out;

public interface SendCpfForValidatioOutputPort {

    void send(String cpf);
}
