package com.example.brejaapi.service.envioService;

import com.example.brejaapi.domain.orm.Envio;

import java.util.Collection;
import java.util.Optional;

public interface EnvioService {
    Collection<Envio> findAll();
    Optional<Envio> findById(Long id);
    Envio save(Envio envio);
    Envio update(Envio envio);
    void deleteById(Long id);
}
