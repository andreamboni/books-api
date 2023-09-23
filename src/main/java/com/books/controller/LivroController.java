package com.books.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Livro;
import com.books.model.request.LivroRequest;
import com.books.model.response.LivroResponse;
import com.books.repository.LivroRepository;
import com.books.service.LivroService;

@RestController
@RequestMapping(path = "livros")
@CrossOrigin
public class LivroController {

	private static final Logger LOGGER = LogManager.getLogger(LivroController.class);

	@Autowired
	private LivroService service;

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(path = "getLivros")
	public List<Livro> getLivros() {
		return livroRepository.findAll();
	}

	@GetMapping(path = "getLivro/{id}") 
	public ResponseEntity<LivroResponse> getLivroById(@PathVariable Long id) {
		Optional<Livro> optionalLivro = livroRepository.findById(id);

		if(optionalLivro.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		LivroResponse response = new LivroResponse();
		response.setLivro(optionalLivro.get());

		return ResponseEntity.ok().body(response);
	}

	@PostMapping(path = "addLivro")
	public ResponseEntity<LivroResponse> addLivro(@RequestBody LivroRequest request) {
		LOGGER.info(">> LivroController.addLivro");

		LOGGER.info("LivroController.addLivro request: " + request.toString());
		LivroResponse response = service.addLivro(request);

		LOGGER.info("<< LivroController.addLivro");
		
		return response.getMensagensErro().isEmpty() ? ResponseEntity.ok().body(response) : ResponseEntity.badRequest().body(response); 
	}
	
	@PostMapping(path = "addLivroTest")
	public ResponseEntity<LivroRequest> addLivroTest(@RequestBody LivroRequest request) {
		return ResponseEntity.ok().body(request); 
	}

	@PutMapping(path = "atualizarLivro/{id}")
	public ResponseEntity<LivroResponse> atualizarLivro(@PathVariable Long id, @RequestBody LivroRequest request) {
		LivroResponse response = service.atualizarLivro(id, request);
		return response.getMensagensErro().isEmpty() ? ResponseEntity.ok().body(response) : ResponseEntity.badRequest().body(response); 
	}

	@DeleteMapping(path = "deleteLivro/{id}")
	public ResponseEntity<String> deleteLivro(@PathVariable Long id) {
		Optional<Livro> optionalLivro = livroRepository.findById(id);

        if(optionalLivro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

		livroRepository.deleteById(id);
		return ResponseEntity.ok().body("O livro '" + optionalLivro.get().getTitulo() + "' foi deletado com sucesso.");
	}

}
