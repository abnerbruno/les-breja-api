package com.example.brejaapi.domain.orm.pedido;

import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.orm.pedido.envio.Envio;
import com.example.brejaapi.domain.orm.pedido.pagamento.Pagamento;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalItens;
    private BigDecimal valorTotal;
    private String status;
    private LocalDate dataCadastro = LocalDate.now();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_itemsPedido",
            joinColumns = { @JoinColumn(name = "pedido_id") },
            inverseJoinColumns = { @JoinColumn(name = "itemPedido_id") })
    private List<ItemPedido> itemsDoPedido;


    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonIgnoreProperties({"pedidos", "enderecos", "cartoes", "cupoms", "trocas"})
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "envio_id")
    private Envio envio;


}
