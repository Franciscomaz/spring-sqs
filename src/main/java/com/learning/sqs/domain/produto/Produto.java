package com.learning.sqs.domain.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "O nome precisa ser informado")
    private String nome;

    @NotNull(message = "O preço precisa ser informado")
    private BigDecimal preco;

    Produto() {
    }

    public Produto(Long id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto alterarPreco(final Porcentagem porcentagem, final TipoAlteracao tipoAlteracao) {
        if (TipoAlteracao.INCREMENTO.equals(tipoAlteracao)) {
            return new Produto(id, nome, preco.add(preco.multiply(porcentagem.toDecimal())));
        } else if (TipoAlteracao.DECREMENTO.equals(tipoAlteracao)) {
            return new Produto(id, nome, preco.add(preco.multiply(porcentagem.asNegativeValue().toDecimal())));
        } else {
            throw new TipoDeAlteracaoNaoEncontrado();
        }
    }

}
