package com.example.brejaapi.api;


import com.example.brejaapi.domain.orm.Troca;
import com.example.brejaapi.service.trocaService.TrocaService;
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
class TrocaController {


    private final Logger log = LoggerFactory.getLogger(TrocaController.class);

    @Autowired
    private final TrocaService trocaService;

    @GetMapping("/trocas")
    Collection<Troca> trocas() {
        log.info("Request to find all Trocas");
        return trocaService.findAll();
    }

    @GetMapping("/troca/{id}")
    ResponseEntity<Troca> getTroca(@Validated @PathVariable Long id) {
        log.info("Request to find Troca by ID: {}", id);
        Optional<Troca> troca = trocaService.findById(id);
        return troca.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/troca")
    ResponseEntity<Troca> createTroca(@RequestBody Troca troca) throws URISyntaxException {
        log.info("Request to create Troca: {}", troca);
        Troca result = trocaService.save(troca);
        return ResponseEntity.created(new URI("/api/troca/" + result.getId()))
                .body(result);
    }

    @PutMapping("/troca/{id}")
    ResponseEntity<Troca> updateTroca(@Validated @RequestBody Troca troca) {
        log.info("Request to update Troca: {}", troca);
        Troca result = trocaService.update(troca);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/troca/{id}")
    public ResponseEntity<Troca> deleteTroca(@PathVariable Long id) {
        log.info("Request to delete Troca: {}", id);
        trocaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
