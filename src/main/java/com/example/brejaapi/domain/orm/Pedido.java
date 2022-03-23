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
    private BigDecimal valorTotal;
    private BigDecimal frete;
    private String status;
    private LocalDate dataCadastro = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "pedido_cerveja",
            joinColumns = { @JoinColumn(name = "pedido_id") },
            inverseJoinColumns = { @JoinColumn(name = "cerveja_id") })
    private List<Cerveja> cervejas;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoEnvio;

    @ManyToOne
    @JoinColumn(name = "cartao_id")
    private Cartao cartaoUtilizado;


}
