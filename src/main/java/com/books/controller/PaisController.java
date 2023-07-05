package com.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Pais> addPais(@RequestBody Pais pais) {
        return ResponseEntity.ok(paisRepository.save(pais));
    }

    @PutMapping(path = "atualizarPais/{id}")
    public ResponseEntity<Pais> atualizarPais(@PathVariable Long id, @RequestBody Pais pais) {
        Optional<Pais> optionalPais = paisRepository.findById(id);

        if(optionalPais.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pais paisAtualizado = Pais.builder()
                                    .id(id)
                                    .nome(pais.getNome())
                                    .build();

        return ResponseEntity.ok(paisRepository.save(paisAtualizado));
    }

    @DeleteMapping(path = "deletePais/{id}")
    public ResponseEntity<String> deletePais(@PathVariable Long id) {
        Optional<Pais> optionalPais = paisRepository.findById(id);

        if(optionalPais.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        paisRepository.delete(optionalPais.get());
        return ResponseEntity.ok().body("O país '" + optionalPais.get().getNome() + "' foi deletado com sucesso.");
    }

}
