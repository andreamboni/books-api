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

import com.books.model.Pais;
import com.books.repository.PaisRepository;

@RestController
@RequestMapping(path = "paises")
@CrossOrigin
public class PaisController {
    
    @Autowired
    private PaisRepository paisRepository;

    @GetMapping(path = "getPaises")
    public ResponseEntity<List<Pais>> getPaises() {
        return ResponseEntity.ok(paisRepository.findAll());
    }

    @PostMapping(path = "addPais")
    public ResponseEntity<?> addPais(@RequestBody Pais pais) {
        return ResponseEntity.ok(paisRepository.save(pais));
    }

}
