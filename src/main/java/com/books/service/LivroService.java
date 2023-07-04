package com.books.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.controller.LivroResponse;
import com.books.model.Autor;
import com.books.model.Colecao;
import com.books.model.Genero;
import com.books.model.Idioma;
import com.books.model.Livro;
import com.books.model.Pais;
import com.books.repository.AutorRepository;
import com.books.repository.ColecaoRepository;
import com.books.repository.GeneroRepository;
import com.books.repository.IdiomaRepository;
import com.books.repository.LivroRepository;
import com.books.repository.PaisRepository;
import com.books.request.LivroRequest;

@Service
public class LivroService {

    @Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private IdiomaRepository idiomaRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private GeneroRepository generoRepository;

	@Autowired
	private ColecaoRepository colecaoRepository;

    public LivroResponse addLivro(LivroRequest request) {
    	LivroResponse response = new LivroResponse();

		Optional<Pais> optionalPais = paisRepository.findByNome(request.getPais());
        Optional<Autor> optionalAutor = autorRepository.findByNome(request.getAutor());
		Optional<Idioma> optionalIdioma = idiomaRepository.findByNome(request.getIdioma());
		Optional<Colecao> optionalColecao = colecaoRepository.findByNome(request.getColecao());

		List<Genero> generos = validateGeneros(request.getGeneros(), response);

		if (optionalPais.isEmpty()) {
			response.addMensagemErro("Pais", "O país " + request.getPais() + " não existe");
		}

		if (optionalAutor.isEmpty()) {
			response.addMensagemErro("Autor", "O autor " + request.getAutor() + " não existe");
		}
        
		if (optionalIdioma.isEmpty()) {
            response.addMensagemErro("Idioma", "O idioma " + request.getIdioma() + " não existe");
		}

        if(response.getMensagensErro().isEmpty()) {
            
            Livro livro = Livro.builder()
                            .colecao(optionalColecao.orElse(null))
                            .titulo(request.getTitulo())
                            .autor(optionalAutor.get())
                            .editora(request.getEditora())
                            .tipo(request.getTipo())
                            .formato(request.getFormato())
                            .quantidadePaginas(request.getQuantidadePaginas())
                            .edicao(request.getEdicao())
                            .anoEdicao(request.getAnoEdicao())
                            .generos(generos)
                            .acabamento(request.getAcabamento())
                            .idioma(optionalIdioma.get())
                            .pais(optionalPais.get())
                            .quantidadeLivros(request.getQuantidadeLivros())
                            .build();


            response.setLivro(livroRepository.save(livro));    
        }

        return response;
    }

    public LivroResponse atualizarLivro(Long id, LivroRequest request) {
		LivroResponse response = new LivroResponse();
        Optional<Livro> optionalLivro = livroRepository.findById(id);

		if(optionalLivro.isEmpty()) {
			response.addMensagemErro("Livro não existe", "O livro com id " + id + " não existe");
			return response;
		}

		Livro livro = optionalLivro.get();
		
		List<Genero> generos = validateGeneros(request.getGeneros(), response);

		Optional<Pais> pais = paisRepository.findByNome(request.getPais());
        Optional<Autor> autor = autorRepository.findByNome(request.getAutor()); 
		Optional<Idioma> idioma = idiomaRepository.findByNome(request.getIdioma()); 
		Optional<Colecao> colecao = colecaoRepository.findByNome(request.getColecao());

		if(request.getColecao() != null && colecao.isEmpty()) {
			response.addMensagemAviso("Coleção", "A coleção " + request.getColecao() + " não existe");
		}

		Livro livroAtualizado = Livro
			.builder()
			.id(id)
			.colecao(colecao.isPresent() ? colecao.get() : livro.getColecao())
			.acabamento(request.getAcabamento() != null ? request.getAcabamento() : livro.getAcabamento())
			.titulo(request.getTitulo() != null ? request.getTitulo() : livro.getTitulo())
			.autor(autor.isPresent() ? autor.get() : livro.getAutor())
			.editora(request.getEditora() != null ? request.getEditora() : livro.getEditora())
			.tipo(request.getTipo() != null ? request.getTipo() : livro.getTipo())
			.formato(request.getFormato() != null ? request.getFormato() : livro.getFormato())
			.quantidadePaginas(request.getQuantidadePaginas() != null ? request.getQuantidadePaginas() : livro.getQuantidadePaginas())
			.edicao(request.getEdicao() !=  null ? request.getEdicao() : livro.getEdicao())
			.anoEdicao(request.getAnoEdicao() !=  null ? request.getAnoEdicao() : livro.getAnoEdicao())
			.generos(generos.size() > 0 ? generos : livro.getGeneros())
			.acabamento(request.getAcabamento() !=  null ? request.getAcabamento() : livro.getAcabamento())
			.idioma(idioma.isPresent() ? idioma.get() : livro.getIdioma())
			.pais(pais.isPresent() ? pais.get() : livro.getPais())
			.quantidadeLivros(request.getQuantidadeLivros() !=  null ? request.getQuantidadeLivros() : livro.getQuantidadeLivros())
			.build();

		response.setLivro(livroRepository.save(livroAtualizado));

        return response;
    }

	private List<Genero> validateGeneros(List<String> generos, LivroResponse response) {
		List<Genero> generosList = new ArrayList<Genero>();
		
		if(generos != null && generos.size() > 0) {
			for(String genero : generos) {
				Genero generoTemp = generoRepository.findByNome(genero);
				if (generoTemp == null) {
					response.addMensagemErro("Genero " + genero, "O genero " + genero + " não existe");
				}
				generosList.add(generoTemp);
			}
		}

		return generosList;
	}

}
