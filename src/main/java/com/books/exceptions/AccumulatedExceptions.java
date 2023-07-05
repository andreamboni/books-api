package com.books.exceptions;

import java.util.ArrayList;
import java.util.List;

public class AccumulatedExceptions extends RuntimeException {
    private List<Exception> exceptions = new ArrayList<>();

    public AccumulatedExceptions(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }
}
