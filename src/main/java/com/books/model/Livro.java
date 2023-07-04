package com.books.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.books.model.enums.Acabamento;
import com.books.model.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "livros")
@Builder
@Getter
public class Livro {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne @JoinColumn(name = "colecao_id") @JsonIgnore
	private Colecao colecao;

	@Column(nullable = false)
	private String titulo;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@Column(nullable = false)
	private String editora;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Formato formato;

	@Column(nullable = false)
	private Integer quantidadePaginas;

	@Column(nullable = false)
	private Integer edicao;

	@Column(nullable = false)
	private Integer anoEdicao;

	@ManyToMany
	@JoinTable(name = "livro_genero", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "genero_id"))
	private List<Genero> generos;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Acabamento acabamento;

	@ManyToOne
	@JoinColumn(name = "idioma_id")
	private Idioma idioma;

	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;

	@Column(nullable = false)
	private Integer quantidadeLivros;

	public Livro() {
	}

	public Livro(Long id, Colecao colecao, String titulo, Autor autor, String editora, Tipo tipo, Formato formato,
			Integer quantidadePaginas, Integer edicao, Integer anoEdicao, List<Genero> generos, Acabamento acabamento,
			Idioma idioma, Pais pais, Integer quantidadeLivros) {
		this.id = id;
		this.colecao = colecao;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.tipo = tipo;
		this.formato = formato;
		this.quantidadePaginas = quantidadePaginas;
		this.edicao = edicao;
		this.anoEdicao = anoEdicao;
		this.generos = generos;
		this.acabamento = acabamento;
		this.idioma = idioma;
		this.pais = pais;
		this.quantidadeLivros = quantidadeLivros;
	}

}
