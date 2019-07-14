package com.learning.sqs.domain.produto;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class AlteracaoDePrecoMessageSender {

    private final JmsTemplate defaultJmsTemplate;

    public AlteracaoDePrecoMessageSender(final JmsTemplate defaultJmsTemplate) {
        this.defaultJmsTemplate = defaultJmsTemplate;
    }

    public void enviarAlteracaoParaProcessamento(final AlteracaoDePreco alteracaoDePreco) {
        defaultJmsTemplate.convertAndSend("produtoAlteracaoPreco", alteracaoDePreco);
    }
}
