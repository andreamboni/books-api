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

import com.books.model.Colecao;
import com.books.repository.ColecaoRepository;

@RestController
@RequestMapping(path = "colecoes")
@CrossOrigin
public class ColecaoController {
    
    @Autowired
    private ColecaoRepository colecaoRepository;

    @GetMapping(path = "getColecoes")
    public ResponseEntity<List<Colecao>> getColecoes() {
        return ResponseEntity.ok(colecaoRepository.findAll());
    }

    @PostMapping(path = "addColecao")
    public ResponseEntity<?> addColecao(@RequestBody Colecao colecao) {
        return ResponseEntity.ok(colecaoRepository.save(colecao));
    }

}
