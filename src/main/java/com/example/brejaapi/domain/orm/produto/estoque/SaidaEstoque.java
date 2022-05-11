package com.example.brejaapi.domain.orm.produto.estoque;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SaidaEstoque")
public class SaidaEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private LocalDate dataCadastro = LocalDate.now();


    @ManyToOne
    @JoinColumn(name = "estoque_id", foreignKey = @ForeignKey(name="SAIDA_TO_ESTOQUE_PRODUTO_FK"))
    private EstoqueProduto estoqueProduto;
}
