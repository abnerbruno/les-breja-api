package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.Envio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends CrudRepository<Envio, Long> {}
