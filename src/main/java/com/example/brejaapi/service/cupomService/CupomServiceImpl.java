package com.example.brejaapi.service.cupomService;

import com.example.brejaapi.domain.orm.Cupom;
import com.example.brejaapi.domain.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CupomServiceImpl implements CupomService {

    @Autowired
    private CupomRepository cupomRepository;

    @Override
    public Collection<Cupom> findAll() {
        return (Collection<Cupom>) cupomRepository.findAll();
    }

    @Override
    public Optional<Cupom> findById(Long id) {
        return cupomRepository.findById(id);
    }
    @Override
    public Optional<Cupom> findByCod(String codigoCupom) {
        return cupomRepository.findCupomByCod(codigoCupom);
    }

    @Override
    public Cupom save(Cupom cupom) {
        return cupomRepository.save(cupom);
    }

    @Override
    public Cupom update(Cupom object) {
        return cupomRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        cupomRepository.deleteById(id);
    }
}
