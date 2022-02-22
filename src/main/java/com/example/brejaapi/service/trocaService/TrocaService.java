package com.example.brejaapi.service.trocaService;

import com.example.brejaapi.domain.orm.Troca;

import java.util.Collection;
import java.util.Optional;

public interface TrocaService {
    Collection<Troca> findAll();
    Optional<Troca> findById(Long id);
    Troca save(Troca troca);
    Troca update(Troca troca);
    void deleteById(Long id);
}
