package com.example.brejaapi.domain.orm.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Enderecos")
public class Endereco {

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

    private String descricao;
}
