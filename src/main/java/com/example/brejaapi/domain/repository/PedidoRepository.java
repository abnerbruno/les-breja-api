package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.pedido.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
