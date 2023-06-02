package com.books.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.books.model.BookModel;
import com.books.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<?> addNewBook(BookModel book) {

        bookRepository.save(book);
        return ResponseEntity.ok().body(book);

    }

}
