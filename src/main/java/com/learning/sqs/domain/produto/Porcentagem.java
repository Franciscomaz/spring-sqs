package com.learning.sqs.domain.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

class Porcentagem implements Serializable {
    private static BigDecimal PORCENTAGEM_COMPLETA = new BigDecimal(100);
    private static int ESCALA_PADRAO = 2;

    private BigDecimal valor;

    public Porcentagem(final String valor) {
        this(new BigDecimal(valor));
    }

    public Porcentagem(final BigDecimal valor) {
        Objects.requireNonNull(valor, "O valor precisa ser informado");

        this.valor = valor;
    }

    public Porcentagem asNegativeValue() {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            return this;
        }

        return new Porcentagem(valor.negate());
    }

    public BigDecimal toDecimal() {
        return valor.divide(PORCENTAGEM_COMPLETA, ESCALA_PADRAO, RoundingMode.CEILING);
    }
}
