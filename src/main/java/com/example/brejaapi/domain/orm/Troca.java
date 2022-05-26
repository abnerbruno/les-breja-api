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
    @JoinColumn(name = "cupom_id", foreignKey = @ForeignKey(name="TROCA_TO_CUPOM_FK"))
    @JsonIgnoreProperties({"cliente"})
    private Cupom cupom;

    @OneToOne
    @JoinColumn(name = "pedido_id", foreignKey = @ForeignKey(name="TROCA_TO_PEDIDO_FK"))
    @JsonIgnoreProperties(value = {"itemsDoPedido", "pagamento", "envio", "cliente"}, allowSetters = true)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name="TROCA_TO_CLIENTE_FK"))
    @JsonIgnoreProperties({"pedidos", "enderecos", "cartoes", "cupoms", "trocas"})
    private Cliente cliente;

}
