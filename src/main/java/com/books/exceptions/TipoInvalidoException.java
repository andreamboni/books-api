package com.books.exceptions;

import org.springframework.http.converter.HttpMessageNotReadableException;

public class TipoInvalidoException extends HttpMessageNotReadableException {

    public TipoInvalidoException(String msg) {
        super(msg);
    }
    
}
