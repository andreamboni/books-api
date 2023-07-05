package com.books.exceptions;

import org.springframework.http.converter.HttpMessageNotReadableException;

public class AutorInvalidoException extends HttpMessageNotReadableException {

    public AutorInvalidoException(String msg) {
        super(msg);
    }

}

