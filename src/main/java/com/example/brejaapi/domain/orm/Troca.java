package com.example.brejaapi.domain.orm;

import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.orm.pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Troca")
public class Troca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String descricaoTroca;
    private BigDecimal valorDesconto;
    private LocalDate dataSolicitacao = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnoreProperties({"itemsDoPedido", "enderecoEnvio", "cartaoUtilizado"})
    private Pedido pedido;

}
