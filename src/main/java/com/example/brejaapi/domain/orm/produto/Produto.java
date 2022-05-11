package com.example.brejaapi.domain.orm.produto;

import com.example.brejaapi.domain.orm.produto.estoque.EntradaEstoque;
import com.example.brejaapi.domain.orm.produto.estoque.EstoqueProduto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
            joinColumns = { @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name="PRODUTO_FK")) },
            inverseJoinColumns = { @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name="CATEGORIA_FK")) })
    private List<Categoria> categorias;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name="PRODUTO_TO_ENTRADA_ESTOQUE_FK"))
    @JsonIgnoreProperties({"estoqueProduto"})
    private List<EntradaEstoque> entradasEstoque;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estoque_id", foreignKey = @ForeignKey(name = "PRODUTO_TO_ESTOQUE_PRODUTO_FK"))
    private EstoqueProduto estoqueProduto;


}
