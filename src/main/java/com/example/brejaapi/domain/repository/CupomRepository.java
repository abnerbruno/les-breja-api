package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.Cupom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupomRepository extends CrudRepository<Cupom, Long> {
    @Query("SELECT c FROM Cupom c WHERE c.codigoCupom = ?1")
    Optional<Cupom> findCupomByCod(String code);
}
