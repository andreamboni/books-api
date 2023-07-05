package com.books.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    // private List<Exception> exceptions = new ArrayList<>();

    // @ExceptionHandler(HttpMessageNotReadableException.class)
    // public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
    //     exceptions.add(ex);
    //     return ResponseEntity.badRequest().body("Erro na desserialização do JSON");
    // }

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<Object> handleException(Exception ex) {
    //     exceptions.add(ex);
    //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor");
    // }

    // @ExceptionHandler(AccumulatedExceptions.class)
    // public ResponseEntity<Object> handleAccumulatedExceptions(AccumulatedExceptions ex) {
    //     List<String> exceptionMessages = new ArrayList<>();
    //     for (Exception exception : ex.getExceptions()) {
    //         exceptionMessages.add(exception.getMessage());
    //     }
    //     return ResponseEntity.badRequest().body(exceptionMessages);
    // }

    // @PostConstruct
    // public void clearExceptions() {
    //     exceptions.clear();
    // }

    // public List<Exception> getExceptions() {
    //     return exceptions;
    // }

}

