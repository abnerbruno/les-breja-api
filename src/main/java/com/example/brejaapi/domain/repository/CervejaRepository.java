package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.produto.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CervejaRepository extends CrudRepository<Produto, Long> {}
