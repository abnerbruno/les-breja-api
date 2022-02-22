package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.Cupom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends CrudRepository<Cupom, Long> {}
