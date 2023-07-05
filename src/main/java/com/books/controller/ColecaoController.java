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

import com.books.model.Colecao;
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
    public ResponseEntity<Colecao> addColecao(@RequestBody Colecao colecao) {
        return ResponseEntity.ok(colecaoRepository.save(colecao));
    }

    @PutMapping(path = "atualizarColecao/{id}")
    public ResponseEntity<Colecao> atualizarColecao(@PathVariable Long id, @RequestBody Colecao colecao) {
        Optional<Colecao> optionalColecao = colecaoRepository.findById(id);

        if(optionalColecao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Colecao colecaoAtualizado = Colecao.builder()
                                    .id(id)
                                    .nome(colecao.getNome())
                                    .build();

        return ResponseEntity.ok(colecaoRepository.save(colecaoAtualizado));
    }

    @DeleteMapping(path = "deleteColecao/{id}")
    public ResponseEntity<String> deleteColecao(@PathVariable Long id) {
        Optional<Colecao> optionalColecao = colecaoRepository.findById(id);

        if(optionalColecao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        colecaoRepository.delete(optionalColecao.get());
        return ResponseEntity.ok().body("A coleção '" + optionalColecao.get().getNome() + "' foi deletada com sucesso.");
    }
    

}
