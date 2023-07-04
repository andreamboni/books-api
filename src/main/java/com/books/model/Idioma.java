package com.books.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "idiomas")
@Builder
@Getter
public class Idioma {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Idioma(){}

    public Idioma(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
