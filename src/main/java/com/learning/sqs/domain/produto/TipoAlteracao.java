package com.learning.sqs.domain.produto;

public enum  TipoAlteracao {

    INCREMENTO("Incremento"),
    DECREMENTO("Decremento");

    private final String nome;

    TipoAlteracao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
