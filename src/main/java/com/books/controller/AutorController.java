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

    @PutMapping(path = "atualizarAutor/{id}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);

        if(optionalAutor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Autor autorAtualizado = Autor.builder()
                                    .id(id)
                                    .nome(autor.getNome() != null ? autor.getNome() : optionalAutor.get().getNome())
                                    .nacionalidade(autor.getNacionalidade() != null ? autor.getNacionalidade() : optionalAutor.get().getNacionalidade())
                                    .dataNascimento(autor.getDataNascimento() != null ? autor.getDataNascimento() : optionalAutor.get().getDataNascimento())
                                    .dataMorte(autor.getDataMorte() != null ? autor.getDataMorte() : optionalAutor.get().getDataMorte())
                                    .build();

        return ResponseEntity.ok(autorRepository.save(autorAtualizado));
    }

    @DeleteMapping(path = "deleteAutor/{id}")
    public ResponseEntity<String> deleteAutor(@PathVariable Long id) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);

        if(optionalAutor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        autorRepository.delete(optionalAutor.get());
        return ResponseEntity.ok().body("O autor '" + optionalAutor.get().getNome() + "' foi deletado com sucesso.");
    }

}
