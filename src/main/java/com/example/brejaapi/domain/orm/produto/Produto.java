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
@Table(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private BigDecimal valorDeVenda;
    private BigDecimal margemDeLucro;
    private String nome;
    private String status;
    private String nomeFornecedor;
    private String descricao;
    private LocalDate dataCadastro = LocalDate.now();

    @Column(length = 64)
    private String photo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "produto_categorias",
            joinColumns = { @JoinColumn(name = "produto_id") },
            inverseJoinColumns = { @JoinColumn(name = "categoria_id") })
    private List<Categoria> categorias;
}
