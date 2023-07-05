package com.books.exceptions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class ExceptionInterceptor implements HandlerInterceptor {

    private List<Exception> exceptions = new ArrayList<>();

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex != null) {
            exceptions.add(ex);
        }
        if (response.getStatus() == HttpServletResponse.SC_OK && !exceptions.isEmpty()) {
            throw new AccumulatedExceptions(exceptions);
        }
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public void clearExceptions() {
        exceptions.clear();
    }
}
