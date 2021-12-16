package com.example.prova.quartaprova.exception.controller;

import com.example.prova.quartaprova.dto.ErrorMessageDTO;
import com.example.prova.quartaprova.exception.ProdutoNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProdutoExceptionController {

    @ExceptionHandler(ProdutoNaoExisteException.class)
    public ResponseEntity<ErrorMessageDTO> handleException(ProdutoNaoExisteException exception){
        return new ResponseEntity<>(
                new ErrorMessageDTO(exception.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

}