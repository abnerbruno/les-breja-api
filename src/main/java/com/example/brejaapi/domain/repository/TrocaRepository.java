package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.Troca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrocaRepository extends CrudRepository<Troca, Long> {}
