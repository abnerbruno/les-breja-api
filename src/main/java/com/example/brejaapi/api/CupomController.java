package com.example.brejaapi.api;


import com.example.brejaapi.domain.orm.Cupom;
import com.example.brejaapi.service.cupomService.CupomService;
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
class CupomController {


    private final Logger log = LoggerFactory.getLogger(CupomController.class);

    @Autowired
    private final CupomService cupomService;

    @GetMapping("/cupoms")
    Collection<Cupom> cupoms() {
        log.info("Request to find all Cupons");
        return cupomService.findAll();
    }

    @GetMapping("/cupom/{id}")
    ResponseEntity<Cupom> getCupom(@Validated @PathVariable Long id) {
        log.info("Request to find Cupom by ID: {}", id);
        Optional<Cupom> cupom = cupomService.findById(id);
        return cupom.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cupom")
    ResponseEntity<Cupom> createCupom(@RequestBody Cupom cupom) throws URISyntaxException {
        log.info("Request to create Cupom: {}", cupom);
        Cupom result = cupomService.save(cupom);
        return ResponseEntity.created(new URI("/api/cupom/" + result.getId()))
                .body(result);
    }

    @PutMapping("/cupom/{id}")
    ResponseEntity<Cupom> updateCupom(@Validated @RequestBody Cupom cupom) {
        log.info("Request to update Cupom: {}", cupom);
        Cupom result = cupomService.update(cupom);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/cupom/{id}")
    public ResponseEntity<Cupom> deleteCupom(@PathVariable Long id) {
        log.info("Request to delete Cupom: {}", id);
        cupomService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
