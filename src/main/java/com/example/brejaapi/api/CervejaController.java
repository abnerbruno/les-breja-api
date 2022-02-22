package com.example.brejaapi.api;

import com.example.brejaapi.domain.orm.produto.Cerveja;
import com.example.brejaapi.service.cervejaService.CervejaService;
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
    private final CervejaService cervejaService;

    @GetMapping("/cervejas")
    Collection<Cerveja> cervejas() {
        return cervejaService.findAll();
    }

    @GetMapping("/cerveja/{id}")
    ResponseEntity<Cerveja> getCerveja(@Validated @PathVariable Long id) {
        log.info("Request to find cerveja by ID: {}", id);
        Optional<Cerveja> cerveja = cervejaService.findById(id);
        return cerveja.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cerveja")
    ResponseEntity<Cerveja> createCerveja(@RequestBody Cerveja cerveja) throws URISyntaxException {
        log.info("Request to create cerveja: {}", cerveja);
        Cerveja result = cervejaService.save(cerveja);
        return ResponseEntity.created(new URI("/api/cerveja/" + result.getId()))
                .body(result);
    }

    @PutMapping("/cerveja")
    ResponseEntity<Cerveja> updateCerveja(@Validated @RequestBody Cerveja cerveja) {
        log.info("Request to update cerveja: {}", cerveja);
        Cerveja result = cervejaService.update(cerveja);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/cerveja/{id}")
    public ResponseEntity<Cerveja> deleteCerveja(@PathVariable Long id) {
        log.info("Request to delete cerveja: {}", id);
        cervejaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
