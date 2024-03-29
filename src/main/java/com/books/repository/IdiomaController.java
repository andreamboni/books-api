package com.books.repository;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Idioma;

@RestController
@RequestMapping(path = "idiomas")
@CrossOrigin
public class IdiomaController {
    
    private static final Logger LOGGER = LogManager.getLogger(IdiomaController.class);

    @Autowired
    private IdiomaRepository idiomaRepository;

    @GetMapping(path = "getIdiomas")
    public ResponseEntity<List<Idioma>> getIdiomas() {
        return ResponseEntity.ok(idiomaRepository.findAll());
    }

    @GetMapping(path = "searchIdioma")
    public ResponseEntity<List<Idioma>> searchIdioma(@RequestParam(name = "idioma", required = false) String idioma) {
        LOGGER.info(">> IdiomaController.searchIdioma");
        
        if(idioma != null) {
            LOGGER.info("<< IdiomaController.searchIdioma idioma is not null");
            return ResponseEntity.ok(idiomaRepository.findByNomeContaining(idioma));
        }
        
        LOGGER.info("<< IdiomaController.searchIdioma");
        return ResponseEntity.ok(idiomaRepository.findAll());
    }

    @PostMapping(path = "addIdioma")
    public ResponseEntity<?> addIdioma(@RequestBody Idioma idioma) {
        return ResponseEntity.ok(idiomaRepository.save(idioma));
    }

    @PutMapping(path = "atualizarIdioma/{id}")
    public ResponseEntity<Idioma> atualizarIdioma(@PathVariable Long id, @RequestBody Idioma idioma) {
        Optional<Idioma> optionalIdioma = idiomaRepository.findById(id);

        if(optionalIdioma.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Idioma idiomaAtualizado = Idioma.builder()
                                    .id(id)
                                    .nome(idioma.getNome())
                                    .build();

        return ResponseEntity.ok(idiomaRepository.save(idiomaAtualizado));
    }

    @DeleteMapping(path = "deleteIdioma/{id}")
    public ResponseEntity<String> deleteIdioma(@PathVariable Long id) {
        Optional<Idioma> optionalIdioma = idiomaRepository.findById(id);

        if(optionalIdioma.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        idiomaRepository.delete(optionalIdioma.get());
        return ResponseEntity.ok().body("O idioma '" + optionalIdioma.get().getNome() + "' foi deletado com sucesso.");
    }

}
