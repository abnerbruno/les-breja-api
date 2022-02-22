package com.example.brejaapi.service.pedidoService;

import com.example.brejaapi.domain.orm.Pedido;

import java.util.Collection;
import java.util.Optional;

public interface PedidoService {
    Collection<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    Pedido save(Pedido pedido);
    Pedido update(Pedido pedido);
    void deleteById(Long id);
}
