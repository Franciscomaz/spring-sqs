package com.learning.sqs.application;

import java.io.Serializable;
import java.math.BigDecimal;

public class NovoProdutoCommand implements Serializable {

    private String nome;
    private BigDecimal preco;

    public NovoProdutoCommand() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
