package com.example.prova.quartaprova.exception.controller;

import com.example.prova.quartaprova.dto.ErrorMessageDTO;
import com.example.prova.quartaprova.exception.FornecedorExistenteException;
import com.example.prova.quartaprova.exception.FornecedorNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FornecedorExceptionController {

    @ExceptionHandler(FornecedorNaoExisteException.class)
    public ResponseEntity<ErrorMessageDTO> handleException(FornecedorNaoExisteException exception){
        return new ResponseEntity<>(
                new ErrorMessageDTO(exception.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(FornecedorExistenteException.class)
    public ResponseEntity<ErrorMessageDTO> handleException(FornecedorExistenteException exception){
        return new ResponseEntity<>(
                new ErrorMessageDTO(exception.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

}