package com.learning.sqs.domain.produto;

import com.learning.sqs.infrastructure.messaging.listener.Receiver;
import com.learning.sqs.infrastructure.repositories.ProdutoRepository;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class ProcessadorAlteracaoDePreco implements Receiver<AlteracaoDePreco> {

    private final ProdutoRepository produtoRepository;

    public ProcessadorAlteracaoDePreco(final ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @JmsListener(destination = "produtoAlteracaoPreco", containerFactory = "defaultContainerFactory")
    public void onMessage(AlteracaoDePreco message) {
        message.getProdutosAfetados().forEach(produtoId -> {
            try {
                final Produto produto = produtoRepository.findByIdOrElseThrow(produtoId);

                final Produto produtoAlterado = produto.alterarPreco(message.getPorcentagem(), message.getTipoAlteracao());

                produtoRepository.save(produtoAlterado);
            } catch (EntityNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

}
