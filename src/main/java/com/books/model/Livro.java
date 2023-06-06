package com.books.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.books.model.enums.Acabamento;
import com.books.model.enums.Idioma;
import com.books.model.enums.Pais;
import com.books.model.enums.Tipo;

@Entity
@Table(name = "livros")
public class Livro {

	@Id	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String colecao;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = false)
	private String autor;

	@Column(nullable = false)
	private String editora;

	@Column(nullable = false) @Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(nullable = false) @Enumerated(EnumType.STRING)
	private Formato formato;

	@Column(nullable = false)
	private Integer quantidadePaginas;

	@Column(nullable = false)
	private Integer edicao;

	@Column(nullable = false)
	private Integer anoEdicao;

	@Column(nullable = false)
	private List<String> genero;

	@Column(nullable = false) @Enumerated(EnumType.STRING)
	private Acabamento acabamento;

	@Column(nullable = false) @Enumerated(EnumType.STRING)
	private Idioma idioma;

	@Column(nullable = false) @Enumerated(EnumType.STRING)
	private Pais pais;

	@Column(nullable = false)
	private Integer quantideLivros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getColecao() {
		return colecao;
	}

	public void setColecao(String colecao) {
		this.colecao = colecao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public Integer getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(Integer quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public Integer getAnoEdicao() {
		return anoEdicao;
	}

	public void setAnoEdicao(Integer anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	public List<String> getGenero() {
		return genero;
	}

	public void setGenero(List<String> genero) {
		this.genero = genero;
	}

	public Acabamento getAcabamento() {
		return acabamento;
	}

	public void setAcabamento(Acabamento acabamento) {
		this.acabamento = acabamento;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Integer getQuantideLivros() {
		return quantideLivros;
	}

	public void setQuantideLivros(Integer quantideLivros) {
		this.quantideLivros = quantideLivros;
	}

}
