package com.example.brejaapi.service.usuarioService;

import com.example.brejaapi.domain.orm.Usuario;

import java.util.Collection;
import java.util.Optional;

public interface UsuarioService {
    Collection<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    void deleteById(Long id);
}
