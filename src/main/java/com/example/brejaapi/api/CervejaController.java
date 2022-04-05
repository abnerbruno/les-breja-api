package com.example.brejaapi.api;

import com.example.brejaapi.domain.orm.produto.Produto;
import com.example.brejaapi.service.produtoService.ProdutoService;
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
class CervejaController {


    private final Logger log = LoggerFactory.getLogger(CervejaController.class);

    @Autowired
    private final ProdutoService produtoService;

    @GetMapping("/cervejas")
    Collection<Produto> cervejas() {
        log.info("Request to find all Cervejas");
        return produtoService.findAll();
    }

    @GetMapping("/cerveja/{id}")
    ResponseEntity<Produto> getCerveja(@Validated @PathVariable Long id) {
        log.info("Request to find cerveja by ID: {}", id);
        Optional<Produto> cerveja = produtoService.findById(id);
        return cerveja.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cerveja")
    ResponseEntity<Produto> createCerveja(@RequestBody Produto produto) throws URISyntaxException {
        log.info("Request to create cerveja: {}", produto);
        Produto result = produtoService.save(produto);
        return ResponseEntity.created(new URI("/api/cerveja/" + result.getId()))
                .body(result);
    }

    @PutMapping("/cerveja/{id}")
    ResponseEntity<Produto> updateCerveja(@Validated @RequestBody Produto produto) {
        log.info("Request to update cerveja: {}", produto);
        Produto result = produtoService.update(produto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/cerveja/{id}")
    public ResponseEntity<Produto> deleteCerveja(@PathVariable Long id) {
        log.info("Request to delete cerveja: {}", id);
        produtoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
