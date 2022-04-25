package com.example.brejaapi.service.envioService;

import com.example.brejaapi.domain.orm.pedido.envio.Envio;
import com.example.brejaapi.domain.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EnvioServiceImpl implements EnvioService{

    @Autowired
    private EnvioRepository envioRepository;

    @Override
    public Collection<Envio> findAll() {
        return (Collection<Envio>) envioRepository.findAll();
    }

    @Override
    public Optional<Envio> findById(Long id) {
        return envioRepository.findById(id);
    }

    @Override
    public Envio save(Envio envio) {
        return envioRepository.save(envio);
    }

    @Override
    public Envio update(Envio envio) {
        return envioRepository.save(envio);
    }

    @Override
    public void deleteById(Long id) {
        envioRepository.deleteById(id);
    }
}
