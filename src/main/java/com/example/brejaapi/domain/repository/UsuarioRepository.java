package com.example.brejaapi.domain.repository;

import com.example.brejaapi.domain.orm.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {}
