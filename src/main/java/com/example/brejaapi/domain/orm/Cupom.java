package com.example.brejaapi.domain.orm;

import com.example.brejaapi.domain.orm.cliente.Cliente;
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
@Table(name = "Cupon")
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoCupom;
    private BigDecimal valor;
    private String tipoCupom; //Troca ou Desconto
    private String status;
    private LocalDate dataValidade;
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name="CUPOM_TO_CLIENTE_FK"))
    @JsonIgnoreProperties({"pedidos", "enderecos", "cartoes", "cupoms", "trocas"})
    private Cliente cliente;
}
