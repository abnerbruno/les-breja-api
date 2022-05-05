package com.example.brejaapi.domain.orm;

import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.orm.pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private LocalDate dataSolicitacao = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "cupom_id")
    @JsonIgnoreProperties({"cliente"})
    private Cupom cupom;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnoreProperties({"itemsDoPedido", "pagamento", "envio", "cliente"})
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"pedidos", "enderecos", "cartoes", "cupoms", "trocas"})
    private Cliente cliente;

}
