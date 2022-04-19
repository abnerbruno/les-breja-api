package com.example.brejaapi.api;


import com.example.brejaapi.domain.orm.pedido.Pedido;
import com.example.brejaapi.service.pedidoService.PedidoService;
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
class PedidoController {


    private final Logger log = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private final PedidoService pedidoService;

    @GetMapping("/pedidos")
    Collection<Pedido> pedidos() {
        log.info("Request to find all Pedidos");
        return pedidoService.findAll();
    }

    @GetMapping("/pedido/{id}")
    ResponseEntity<Pedido> getPedido(@Validated @PathVariable Long id) {
        log.info("Request to find Pedido by ID: {}", id);
        Optional<Pedido> pedido = pedidoService.findById(id);
        return pedido.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/pedido")
    ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) throws URISyntaxException {
        log.info("Request to create Pedido: {}", pedido);
        Pedido result = pedidoService.save(pedido);
        return ResponseEntity.created(new URI("/api/pedido/" + result.getId()))
                .body(result);
    }

    @PutMapping("/pedido/{id}")
    ResponseEntity<Pedido> updatePedido(@Validated @RequestBody Pedido pedido) {
        log.info("Request to update Pedido: {}", pedido);
        Pedido result = pedidoService.update(pedido);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<Pedido> deletePedido(@PathVariable Long id) {
        log.info("Request to delete Pedido: {}", id);
        pedidoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
