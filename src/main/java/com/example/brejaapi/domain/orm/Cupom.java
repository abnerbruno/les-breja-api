package com.example.brejaapi.domain.orm;

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
@Table(name = "Cupons")
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoCupom;
    private BigDecimal valor;
    private String tipoCupom; //Troca ou Desconto
    private LocalDate dataValidade;
    private LocalDate dataCriacao = LocalDate.now();
}
