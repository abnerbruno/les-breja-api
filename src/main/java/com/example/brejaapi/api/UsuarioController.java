package com.example.brejaapi.api;


import com.example.brejaapi.domain.orm.Usuario;
import com.example.brejaapi.service.usuarioService.UsuarioService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
class UsuarioController {


    private final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private final UsuarioService usuarioService;

    @GetMapping("/usuarios")
    Collection<Usuario> usuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    ResponseEntity<Usuario> getUsuario(@Validated @PathVariable Long id) {
        log.info("Request to find Usuario by ID: {}", id);
        Optional<Usuario> usuario = usuarioService.findById(id);
        return usuario.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/usuario")
    ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) throws URISyntaxException {
        log.info("Request to create Usuario: {}", usuario);
        Usuario result = usuarioService.save(usuario);
        return ResponseEntity.created(new URI("/api/usuario/" + result.getId()))
                .body(result);
    }

    @PutMapping("/usuario")
    ResponseEntity<Usuario> updateUsuario(@Validated @RequestBody Usuario usuario) {
        log.info("Request to update Usuario: {}", usuario);
        Usuario result = usuarioService.update(usuario);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        log.info("Request to delete Usuario: {}", id);
        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
