package com.books.model.enums;

public enum Tipo {

    LIVRO("Livro"), 
    GIBI("Gibi"),
    MANGA("Manga");

    private String nome;

    Tipo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
