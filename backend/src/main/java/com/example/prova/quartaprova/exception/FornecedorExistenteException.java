package com.example.prova.quartaprova.exception;

public class FornecedorExistenteException extends RuntimeException {

    public FornecedorExistenteException (String cnpj) {
        super(String.format("Fornecedor com cnpj %s já existe", cnpj));
    }
}

