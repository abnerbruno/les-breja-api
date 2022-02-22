package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {}
