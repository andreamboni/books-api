package com.books.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<BookError> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        BookError error = new BookError();
        error.setErrorMessage("Erro de integridade de dados. Todos os campos são obrigatórios, exceto 'collection'.");
        error.setFieldsAvailable("collection, title, author, publisher, type, format, pages, edition, editionYear, genres, finishing, language, country e bookQuantity.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}