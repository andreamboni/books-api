package com.books.controller;

import java.util.List;

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

	@Autowired
	private LivroService service;

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(path = "getLivros")
	public List<Livro> getLivros() {
		return livroRepository.findAll();
	}

	@PostMapping(path = "addLivro")
	public ResponseEntity<LivroResponse> addLivro(@RequestBody LivroRequest request) {
		LivroResponse response = service.addLivro(request);
		return response.getMensagensErro().isEmpty() ? ResponseEntity.ok().body(response) : ResponseEntity.badRequest().body(response); 
	}

	@PutMapping(path = "atualizarLivro/{id}")
	public ResponseEntity<LivroResponse> atualizarLivro(@PathVariable Long id, @RequestBody LivroRequest request) {
		LivroResponse response = service.atualizarLivro(id, request);
		return response.getMensagensErro().isEmpty() ? ResponseEntity.ok().body(response) : ResponseEntity.badRequest().body(response); 
	}

	@DeleteMapping(path = "deleteLivro/{id}")
	public ResponseEntity<String> deleteLivro(@PathVariable Long id) {
		livroRepository.deleteById(id);
		return ResponseEntity.ok("Livro foi deleteado com sucesso");
	}

}
