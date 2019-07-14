package com.learning.sqs.infrastructure.repositories;

import com.learning.sqs.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    default Produto findByIdOrElseThrow(final Long id) {
        return findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com id " + id + " não foi encontrado"));
    }

}
