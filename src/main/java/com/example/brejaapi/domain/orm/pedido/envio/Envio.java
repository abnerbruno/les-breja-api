package com.example.brejaapi.domain.orm.pedido.envio;

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
@Table(name = "Envio")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longadouro;
    private String tipoLongadouro;
    private String tipoResidencia;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;

    private BigDecimal frete;

    private String statusEnvio;
    private LocalDate dataCriacao = LocalDate.now();

}
