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

    @PutMapping(path = "atualizarGenero/{id}")
    public ResponseEntity<Genero> atualizarGenero(@PathVariable Long id, @RequestBody Genero genero) {
        Optional<Genero> optionalGenero = generoRepository.findById(id);

        if(optionalGenero.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Genero generoAtualizado = Genero.builder()
                                    .id(id)
                                    .nome(genero.getNome())
                                    .build();

        return ResponseEntity.ok(generoRepository.save(generoAtualizado));
    }

    @DeleteMapping(path = "deleteGenero/{id}")
    public ResponseEntity<String> deleteGenero(@PathVariable Long id) {
        Optional<Genero> optionalGenero = generoRepository.findById(id);

        if(optionalGenero.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        generoRepository.delete(optionalGenero.get());
        return ResponseEntity.ok().body("O gênero '" + optionalGenero.get().getNome() + "' foi deletado com sucesso.");
    }


}
