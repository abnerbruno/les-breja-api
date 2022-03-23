package com.example.brejaapi.service.pedidoService;

import com.example.brejaapi.domain.orm.Pedido;
import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Collection<Pedido> findAll() {
        return (Collection<Pedido>) pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {

        Optional<Pedido> pedido = pedidoRepository.findById(id);
        pedido.get().setCliente(buildCliente(pedido));
        return pedido;
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    private Cliente buildCliente(Optional<Pedido> pedido){
        Cliente cliente = new Cliente(
                pedido.get().getCliente().getId(),
                pedido.get().getCliente().getNomeCompleto(),
                pedido.get().getCliente().getCpf(),
                pedido.get().getCliente().getClassificacao(),
                pedido.get().getCliente().getEmail(),
                pedido.get().getCliente().getTelefone(),
                pedido.get().getCliente().getDataNascimento(),
                pedido.get().getCliente().getGenero(),
                pedido.get().getCliente().getStatus());
        return cliente;
    }
}
