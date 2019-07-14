package com.learning.sqs.resources;

import com.learning.sqs.application.NovoProdutoCommand;
import com.learning.sqs.application.ProdutoService;
import com.learning.sqs.domain.produto.AlteracaoDePreco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "produtos")
public class ProdutoResource {

    private final ProdutoService produtoService;

    public ProdutoResource(final ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody final NovoProdutoCommand novoProdutoCommand) {
        return ResponseEntity.ok(produtoService.criar(novoProdutoCommand));
    }

    @PostMapping(value = "/preco/alterar")
    public ResponseEntity alterarPrecoEmMassa(@RequestBody final AlteracaoDePreco alteracaoDePreco) {
        produtoService.alterarPrecoEmMassa(alteracaoDePreco);
        return ResponseEntity
                .ok()
                .build();
    }

}
