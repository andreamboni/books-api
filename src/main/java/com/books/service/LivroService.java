package com.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.books.model.Livro;
import com.books.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository bookRepository;

    public ResponseEntity<?> addNewBook(Livro book) {

        bookRepository.save(book);
        return ResponseEntity.ok().body(book);

    }

}
