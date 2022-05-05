package com.example.brejaapi.domain.orm.pedido;

import com.example.brejaapi.domain.orm.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name="ITEMPEDIDO_TO_PEDIDO_FK"))
    private Produto produto;

    private int quantidade;
}
