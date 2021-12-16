package com.example.prova.quartaprova.exception;

public class FornecedorNaoExisteException extends RuntimeException {

    public FornecedorNaoExisteException (Long id) {
        super(String.format("Fornecedor com id %d não existe", id));
    }
}