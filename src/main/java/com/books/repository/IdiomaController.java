package com.books.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Idioma;

@RestController
@RequestMapping(path = "idiomas")
@CrossOrigin
public class IdiomaController {
    
    @Autowired
    private IdiomaRepository idiomaRepository;

    @GetMapping(path = "getIdiomas")
    public ResponseEntity<List<Idioma>> getIdiomas() {
        return ResponseEntity.ok(idiomaRepository.findAll());
    }

    @PostMapping(path = "addIdioma")
    public ResponseEntity<?> addIdioma(Idioma idioma) {
        return ResponseEntity.ok(idiomaRepository.save(idioma));
    }

}
