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
import com.books.request.LivroRequest;

@Entity
@Table(name = "livros")
public class Livro {

	// @TableGenerator(name = "id_generator", table = "livros", pkColumnName = "sequence_name", valueColumnName = "next_value", allocationSize = 1, initialValue = 100)
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String colecao;

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
    @JoinTable(
        name = "livro_genero",
        joinColumns = @JoinColumn(name = "livro_id"),
        inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
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

	public Livro(LivroRequest request, Autor autor, Idioma idioma, Pais pais) {
		this.colecao = request.getColecao();
		this.titulo = request.getTitulo();
		this.autor = autor;
		this.editora = request.getEditora();
		this.tipo = request.getTipo();
		this.formato = request.getFormato();
		this.quantidadePaginas = request.getQuantidadePaginas();
		this.edicao = request.getEdicao();
		this.anoEdicao = request.getAnoEdicao();
		this.generos = request.getGeneros();
		this.acabamento = request.getAcabamento();
		this.idioma = idioma;
		this.pais = pais;
		this.quantidadeLivros = request.getQuantideLivros();
	}

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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
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

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
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

	public Integer getQuantidadeLivros() {
		return quantidadeLivros;
	}

	public void setQuantidadeLivros(Integer quantidadeLivros) {
		this.quantidadeLivros = quantidadeLivros;
	}

}
