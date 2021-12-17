package com.example.prova.quartaprova.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NamelessProductException extends RuntimeException{

    public NamelessProductException(String msg){
        super(msg);
    }
}