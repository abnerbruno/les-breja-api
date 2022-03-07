package com.example.brejaapi.domain.orm.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cerveja")
public class Cerveja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valorDeVenda;
    private BigDecimal margemDeLucro;
    private int quantidade;
    private String status;
    private String nomeFornecedor;
    private LocalDate dataCadastro = LocalDate.now();
    private String descricao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cerveja_has_categorias",
            joinColumns = { @JoinColumn(name = "cerveja_id") },
            inverseJoinColumns = { @JoinColumn(name = "categoria_id") })
    private List<Categoria> categorias;
}
