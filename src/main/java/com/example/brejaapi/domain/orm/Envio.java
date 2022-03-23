package com.example.brejaapi.domain.orm;

import com.example.brejaapi.domain.orm.cliente.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Long numeroPedido;
    private String status;
    private LocalDate dataCriacao = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
