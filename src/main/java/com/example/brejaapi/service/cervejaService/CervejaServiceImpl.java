package com.example.brejaapi.service.cervejaService;

import com.example.brejaapi.domain.orm.produto.Cerveja;
import com.example.brejaapi.domain.repository.CervejaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CervejaServiceImpl implements CervejaService {

    @Autowired
    private final CervejaRepository cervejaRepository;

    @Override
    public Collection<Cerveja> findAll() {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        return (Collection<Cerveja>) cervejaRepository.findAll();
    }

    @Override
    public Optional<Cerveja> findById(Long id) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        return cervejaRepository.findById(id);
    }

    @Override
    public Cerveja save(Cerveja cerveja) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        return cervejaRepository.save(cerveja);
    }

    @Override
    public Cerveja update(Cerveja cerveja) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        return cervejaRepository.save(cerveja);
    }

    @Override
    public void deleteById(Long id) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        cervejaRepository.deleteById(id);
    }
}
