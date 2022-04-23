package com.example.brejaapi.domain.orm;

import com.example.brejaapi.domain.orm.cliente.Endereco;
import com.example.brejaapi.domain.orm.pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Envio")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDate dataCriacao = LocalDate.now();

    @JsonIgnoreProperties({"cliente", "cartaoUtilizado"})
    @JoinColumn(name = "pedido_id")
    @OneToOne
    private Pedido pedido;

}
