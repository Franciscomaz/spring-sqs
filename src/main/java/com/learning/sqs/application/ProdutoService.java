package com.learning.sqs.application;

import com.learning.sqs.domain.produto.AlteracaoDePreco;
import com.learning.sqs.domain.produto.AlteracaoDePrecoMessageSender;
import com.learning.sqs.domain.produto.Produto;
import com.learning.sqs.infrastructure.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final AlteracaoDePrecoMessageSender alteracaoDePrecoMessageSender;

    public ProdutoService(final ProdutoRepository produtoRepository,
                          final AlteracaoDePrecoMessageSender alteracaoDePrecoMessageSender) {
        this.produtoRepository = produtoRepository;
        this.alteracaoDePrecoMessageSender = alteracaoDePrecoMessageSender;
    }

    public Produto buscarPeloId(final Long id) {
        return produtoRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com id " + id + " não foi encontrado"));
    }

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto criar(final NovoProdutoCommand novoProdutoCommand) {
        return produtoRepository.save(novoProdutoCom(novoProdutoCommand.getNome(), novoProdutoCommand.getPreco()));
    }

    public void alterarPrecoEmMassa(final AlteracaoDePreco alteracaoDePreco) {
        alteracaoDePrecoMessageSender.enviarAlteracaoParaProcessamento(alteracaoDePreco);
    }

    private Produto novoProdutoCom(final String nome, final BigDecimal preco) {
        return new Produto(null, nome, preco);
    }

}
