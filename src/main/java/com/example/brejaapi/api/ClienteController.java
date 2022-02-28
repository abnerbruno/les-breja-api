package com.example.brejaapi.api;


import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.service.clienteService.ClienteService;
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
class ClienteController {


    private final Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private final ClienteService clienteService;

    @GetMapping("/clientes")
    Collection<Cliente> clientes() {
        log.info("Request to find all clientes");
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{id}")
    ResponseEntity<Cliente> getCliente(@Validated @PathVariable Long id) {
        log.info("Request to find cliente by ID: {}", id);
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cliente")
    ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) throws URISyntaxException {
        log.info("Request to create cliente: {}", cliente);
        Cliente result = clienteService.save(cliente);
        return ResponseEntity.created(new URI("/api/cliente/" + result.getId()))
                .body(result);
    }

    @PutMapping("/cliente")
    ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @Validated @RequestBody Cliente cliente) {
        log.info("Request to update cliente: {}", cliente);
        Cliente clienteAtual = clienteService.findById(id).orElseThrow(RuntimeException::new);
        Cliente result = clienteService.update(cliente);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        log.info("Request to delete cliente: {}", id);
        clienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
