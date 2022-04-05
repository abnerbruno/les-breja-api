package com.example.brejaapi.domain.orm;

import com.example.brejaapi.domain.orm.pedido.Pedido;
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

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
