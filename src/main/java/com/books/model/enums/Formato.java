package com.books.model.enums;

public enum Formato {

    FISICO("Físico"),
    DIGITAL("Digital");

    private String nome;

    Formato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
