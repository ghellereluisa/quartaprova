package com.example.prova.quartaprova.exception.controller;

import com.example.prova.quartaprova.dto.ErrorMessageDTO;
import com.example.prova.quartaprova.exception.TipoProdutoExistenteException;
import com.example.prova.quartaprova.exception.TipoProdutoNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TipoProdutoExceptionController {

    @ExceptionHandler(TipoProdutoNaoExisteException.class)
    public ResponseEntity<ErrorMessageDTO> handleException(TipoProdutoNaoExisteException exception){
        return new ResponseEntity<>(
                new ErrorMessageDTO(exception.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(TipoProdutoExistenteException.class)
    public ResponseEntity<ErrorMessageDTO> handleException(TipoProdutoExistenteException exception){
        return new ResponseEntity<>(
                new ErrorMessageDTO(exception.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

}