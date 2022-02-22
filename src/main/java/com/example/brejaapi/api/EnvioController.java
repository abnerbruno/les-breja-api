package com.example.brejaapi.api;


import com.example.brejaapi.domain.orm.Envio;
import com.example.brejaapi.service.envioService.EnvioService;
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
class EnvioController {


    private final Logger log = LoggerFactory.getLogger(EnvioController.class);

    @Autowired
    private final EnvioService envioService;

    @GetMapping("/envios")
    Collection<Envio> envios() {
        return envioService.findAll();
    }

    @GetMapping("/envio/{id}")
    ResponseEntity<Envio> getEnvio(@Validated @PathVariable Long id) {
        log.info("Request to find Envio by ID: {}", id);
        Optional<Envio> envio = envioService.findById(id);
        return envio.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/envio")
    ResponseEntity<Envio> createEnvio(@RequestBody Envio envio) throws URISyntaxException {
        log.info("Request to create Envio: {}", envio);
        Envio result = envioService.save(envio);
        return ResponseEntity.created(new URI("/api/envio/" + result.getId()))
                .body(result);
    }

    @PutMapping("/envio")
    ResponseEntity<Envio> updateEnvio(@Validated @RequestBody Envio envio) {
        log.info("Request to update Envio: {}", envio);
        Envio result = envioService.update(envio);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/envio/{id}")
    public ResponseEntity<Envio> deleteEnvio(@PathVariable Long id) {
        log.info("Request to delete Envio: {}", id);
        envioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
