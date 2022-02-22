package com.example.brejaapi.service.cervejaService;
import com.example.brejaapi.domain.orm.produto.Cerveja;

import java.util.Collection;
import java.util.Optional;

public interface CervejaService {
    Collection<Cerveja> findAll();
    Optional<Cerveja> findById(Long id);
    Cerveja save(Cerveja cerveja);
    Cerveja update(Cerveja cerveja);
    void deleteById(Long id);
}
