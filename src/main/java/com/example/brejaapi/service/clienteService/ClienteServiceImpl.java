package com.example.brejaapi.service.clienteService;


import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    @Override
    public Collection<Cliente> findAll() {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO
        return (Collection<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        //QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO
        clienteRepository.deleteById(id);
    }

}
