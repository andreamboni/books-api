package com.books.model.enums;

public enum Acabamento {

    BROCHURA("Brochura"),
    CAPA_DURA("Capa Dura"),
    BOX_BROCHURA("Box Brochura"),
    BOX_CAPA_DURA("Box Capa Dura");


    private String nome;

    Acabamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
