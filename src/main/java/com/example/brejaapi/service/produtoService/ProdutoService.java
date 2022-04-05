package com.example.brejaapi.service.produtoService;
import com.example.brejaapi.domain.orm.produto.Produto;

import java.util.Collection;
import java.util.Optional;

public interface ProdutoService {
    Collection<Produto> findAll();
    Optional<Produto> findById(Long id);
    Produto save(Produto produto);
    Produto update(Produto produto);
    void deleteById(Long id);
}
