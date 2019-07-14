package com.learning.sqs.domain.produto;

public class TipoDeAlteracaoNaoEncontrado extends RuntimeException {
    public TipoDeAlteracaoNaoEncontrado() {
        super("Tipo de alteração informado não foi encontrado.");
    }

    public TipoDeAlteracaoNaoEncontrado(String message) {
        super(message);
    }
}
