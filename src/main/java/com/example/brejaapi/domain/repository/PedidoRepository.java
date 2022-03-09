package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.Pedido;
import com.example.brejaapi.domain.orm.produto.Cerveja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {}
