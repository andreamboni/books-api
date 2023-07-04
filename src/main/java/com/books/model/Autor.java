package com.books.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "autores")
@JsonInclude(Include.NON_EMPTY)
@Builder
@Getter
public class Autor {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String nacionalidade;

	@Column(nullable = false) @JsonFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataMorte;

	public Autor(){}

	public Autor(Long id, String nome, String nacionalidade, Date dataNascimento, Date dataMorte) {
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.dataNascimento = dataNascimento;
		this.dataMorte = dataMorte;
	}

}
