package com.example.brejaapi.service.trocaService;

import com.example.brejaapi.domain.orm.Cupom;
import com.example.brejaapi.domain.orm.Troca;
import com.example.brejaapi.domain.orm.pedido.ItemPedido;
import com.example.brejaapi.domain.orm.pedido.Pedido;
import com.example.brejaapi.domain.orm.produto.Produto;
import com.example.brejaapi.domain.orm.produto.estoque.EntradaEstoque;
import com.example.brejaapi.domain.repository.CervejaRepository;
import com.example.brejaapi.domain.repository.CupomRepository;
import com.example.brejaapi.domain.repository.TrocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class TrocaServiceImpl implements TrocaService {

    @Autowired
    private TrocaRepository trocaRepository;

    @Autowired
    private CervejaRepository cervejaRepository;

    @Autowired
    private CupomRepository cupomRepository;

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
        String status = troca.getStatus();
        if(status.contains("Troca Aprovado") && troca.getCupom() == null){
            Cupom cupom = new Cupom();
            cupom.setCodigoCupom("TROC" + troca.getId());
            cupom.setValor(new BigDecimal(10));
            cupom.setTipoCupom("Troca");
            cupom.setStatus("Ativo");
            cupom.setDataValidade(LocalDate.now().plusDays(5));
            cupom.setDataValidade(LocalDate.now());

            cupom.setCliente(troca.getCliente());
            Long cupomID = cupomRepository.save(cupom).getId();

            cupom.setId(cupomID);

            troca.setCupom(cupom);

            Pedido pedido = troca.getPedido();
            for(ItemPedido item : pedido.getItemsDoPedido()){
                if(pedido.getStatus().equals("Pagamento Aprovado") && item.getStatus().equals("Aprovado")) {
                    Produto produto = item.getProduto();

                    int quantidade = produto.getEstoqueProduto().getQuantidadeAtual();
                    produto.getEstoqueProduto().setQuantidadeAtual(quantidade + item.getSaidasEstoque().getQuantidade());

                    EntradaEstoque entradaEstoque = new EntradaEstoque();
                    entradaEstoque.setQuantidade(item.getSaidasEstoque().getQuantidade());
                    produto.getEntradasEstoque().add(entradaEstoque);
                    item.setStatus("Trocado");

                    cervejaRepository.save(produto);
                }
            }
        }
        return trocaRepository.save(troca);
    }

    @Override
    public void deleteById(Long id) {
        trocaRepository.deleteById(id);
    }
}
