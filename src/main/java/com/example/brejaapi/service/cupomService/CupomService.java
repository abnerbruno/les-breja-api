package com.example.brejaapi.service.cupomService;

import com.example.brejaapi.domain.orm.Cupom;

import java.util.Collection;
import java.util.Optional;

public interface CupomService {
    Collection<Cupom> findAll();
    Optional<Cupom> findById(Long id);
    Cupom save(Cupom cupom);
    Cupom update(Cupom object);
    void deleteById(Long id);
}
