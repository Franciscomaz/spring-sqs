package com.learning.sqs.domain.produto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AlteracaoDePreco implements Serializable {

    private final Porcentagem porcentagem;
    private final TipoAlteracao tipoAlteracao;
    private final List<Long> produtosAfetados;

    public AlteracaoDePreco(final Porcentagem porcentagem,
                            final TipoAlteracao tipoAlteracao,
                            final List<Long> produtosAfetados) {

        Objects.requireNonNull(porcentagem, "A porcentagem da alteração precisa ser informada");
        Objects.requireNonNull(tipoAlteracao, "O tipo da alteração precisa ser informado");
        Objects.requireNonNull(produtosAfetados, "O tipo da alteração precisa ser informado");

        this.porcentagem = porcentagem;
        this.tipoAlteracao = tipoAlteracao;
        this.produtosAfetados = produtosAfetados;
    }

    public static AlteracaoDePreco fromJson(final String json) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, AlteracaoDePreco.class);
    }

    public Porcentagem getPorcentagem() {
        return porcentagem;
    }

    public TipoAlteracao getTipoAlteracao() {
        return tipoAlteracao;
    }

    public List<Long> getProdutosAfetados() {
        return produtosAfetados;
    }

    public String toJson() throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
