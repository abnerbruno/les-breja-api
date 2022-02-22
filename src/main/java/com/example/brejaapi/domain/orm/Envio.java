package com.example.brejaapi.domain.orm;

import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.orm.produto.Cerveja;
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
@Table(name = "Envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDate dataCriacao = LocalDate.now();

    @OneToOne
    private Cliente cliente;

    @OneToMany
    @JoinTable(name = "envio_cerveja",
            joinColumns = { @JoinColumn(name = "envio_id") },
            inverseJoinColumns = { @JoinColumn(name = "cerveja_id") })
    private List<Cerveja> cerveja;
}
