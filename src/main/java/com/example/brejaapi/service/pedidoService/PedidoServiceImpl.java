package com.example.brejaapi.service.pedidoService;

import com.example.brejaapi.domain.orm.pedido.ItemPedido;
import com.example.brejaapi.domain.orm.pedido.Pedido;
import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.orm.produto.Produto;
import com.example.brejaapi.domain.orm.produto.estoque.SaidaEstoque;
import com.example.brejaapi.domain.repository.CervejaRepository;
import com.example.brejaapi.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CervejaRepository cervejaRepository;

    @Override
    public Collection<Pedido> findAll() {
        return (Collection<Pedido>) pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        switch (pedido.getStatus()) {
            case "Pagamento Aprovado":

                for(ItemPedido item : pedido.getItemsDoPedido()){
                    if(item.getStatus().equals("Em Processo")) {
                        Produto produto = item.getProduto();

                        int quantidade = produto.getEstoqueProduto().getQuantidadeAtual();
                        produto.getEstoqueProduto().setQuantidadeAtual(quantidade - item.getQuantidade());

                        SaidaEstoque saidaEstoque = new SaidaEstoque();
                        saidaEstoque.setQuantidade(item.getQuantidade());
                        saidaEstoque.setEstoqueProduto(produto.getEstoqueProduto());
                        item.setSaidasEstoque(saidaEstoque);
                        item.setStatus("Aprovado");

                        cervejaRepository.save(produto);
                    }
                }
                break;

            default:
                break;
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

}
