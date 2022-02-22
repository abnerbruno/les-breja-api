package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.produto.Cerveja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervejaRepository extends CrudRepository<Cerveja, Long> {
    void findCervejasByCategoriaId(Long categoriaId);
}
