package com.example.brejaapi.service.produtoService;

import com.example.brejaapi.domain.orm.produto.Produto;
import com.example.brejaapi.domain.repository.CervejaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private final CervejaRepository cervejaRepository;

    @Override
    public Collection<Produto> findAll() {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        return (Collection<Produto>) cervejaRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        return cervejaRepository.findById(id);
    }

    @Override
    public Produto save(Produto produto) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        return cervejaRepository.save(produto);
    }

    @Override
    public Produto update(Produto produto) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        return cervejaRepository.save(produto);
    }

    @Override
    public void deleteById(Long id) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        cervejaRepository.deleteById(id);
    }
}
