package com.example.brejaapi.domain.orm;

import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.orm.produto.Cerveja;
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
    private LocalDate dataSolicitacao = LocalDate.now();

    @OneToOne
    private Pedido pedido;

    @OneToOne
    private Cerveja cerveja;

    @OneToOne
    private Cliente cliente;

}
