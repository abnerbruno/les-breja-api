package com.example.brejaapi.domain.orm.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NomeNoCartao;
    private String numeroCartao;
    private Date Validade;
    private String codigoSeguranca;
    private String tipoConta;
    private String bandeira;
    
    private String descricao;
}
