package com.books.model.enums;

public enum Pais {

    BRASIL("Brasil"),
    ARGENTINA("Argentina"),
    EUA("Estados Unidos da América"),
    REINO_UNIDO("Reino Unido");

    private String nome;

    Pais(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
