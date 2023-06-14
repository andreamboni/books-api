package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Autor;
import com.books.repository.AutorRepository;

@RestController
@RequestMapping(path = "autores")
@CrossOrigin
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping(path = "getAutores")
    public ResponseEntity<List<Autor>> getAutor() {
        return ResponseEntity.ok(autorRepository.findAll());
    }

    @PostMapping(path = "addAutor")
    public ResponseEntity<Autor> addAutor(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorRepository.save(autor));
    }

}
