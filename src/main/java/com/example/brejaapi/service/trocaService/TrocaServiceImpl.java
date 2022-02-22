package com.example.brejaapi.service.trocaService;

import com.example.brejaapi.domain.orm.Troca;
import com.example.brejaapi.domain.repository.TrocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TrocaServiceImpl implements TrocaService {

    @Autowired
    private TrocaRepository trocaRepository;

    @Override
    public Collection<Troca> findAll() {
        return (Collection<Troca>) trocaRepository.findAll();
    }

    @Override
    public Optional<Troca> findById(Long id) {
        return trocaRepository.findById(id);
    }

    @Override
    public Troca save(Troca troca) {
        return trocaRepository.save(troca);
    }

    @Override
    public Troca update(Troca troca) {
        return trocaRepository.save(troca);
    }

    @Override
    public void deleteById(Long id) {
        trocaRepository.deleteById(id);
    }
}
