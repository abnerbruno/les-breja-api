package com.example.brejaapi.domain.orm;

import com.example.brejaapi.domain.orm.cliente.Cartao;
import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.orm.cliente.Endereco;
import com.example.brejaapi.domain.orm.produto.Cerveja;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorTotal;
    private BigDecimal frete;
    private String status;

    @ManyToOne
    @JoinTable(name = "pedido_cliente",
            joinColumns = { @JoinColumn(name = "pedido_id") },
            inverseJoinColumns = { @JoinColumn(name = "cliente_id") })
    private Cliente cliente;

    @OneToOne
    private Endereco enderecoEnvio;

    @OneToOne
    private Cartao cartaoUtilizado;

    @OneToMany
    @JoinTable(name = "pedido_cerveja",
            joinColumns = { @JoinColumn(name = "pedido_id") },
            inverseJoinColumns = { @JoinColumn(name = "cerveja_id") })
    private List<Cerveja> cervejas;
}
