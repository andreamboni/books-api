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

import com.books.model.Autor;
import com.books.model.Livro;
import com.books.repository.AutorRepository;
import com.books.repository.LivroRepository;
import com.books.request.LivroRequest;

@RestController
@RequestMapping(path = "livros")
@CrossOrigin
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping(value = "getLivros")
	public List<Livro> getAllMyBooks() {
		return livroRepository.findAll();
	}

	@PostMapping(value = "addLivro")
	public ResponseEntity<?> addBook(@RequestBody LivroRequest request) {
		Autor autor = autorRepository.findByNome(request.getAutor());

		if (autor == null) {
			return ResponseEntity.badRequest().body("O autor não existe");
		}

		return ResponseEntity.ok(livroRepository.save(new Livro(request, autor)));
	}

}
