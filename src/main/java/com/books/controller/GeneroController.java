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

import com.books.model.Genero;
import com.books.repository.GeneroRepository;

@RestController
@RequestMapping(path = "generos")
@CrossOrigin
public class GeneroController {
    
    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping(path = "getGeneros")
    public ResponseEntity<List<Genero>> getGeneros() {
        return ResponseEntity.ok(generoRepository.findAll());
    }

    @PostMapping(path = "addGenero")
    public ResponseEntity<?> addGenero(@RequestBody Genero genero) {
        return ResponseEntity.ok(generoRepository.save(genero));
    }

}
