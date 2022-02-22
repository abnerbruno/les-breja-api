package com.example.brejaapi.service.clienteService;

import com.example.brejaapi.domain.orm.cliente.Cliente;

import java.util.Collection;
import java.util.Optional;

public interface ClienteService {
    Collection<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    void deleteById(Long id);
}
