package com.books.model.enums;

public enum Idioma {

    PORTUGUES("Português"),
    INGLES("Inglês"),
    ESPANHOL("Espanhol");

    private String nome;

    Idioma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
