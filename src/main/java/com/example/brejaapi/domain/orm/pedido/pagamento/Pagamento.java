package com.example.brejaapi.domain.orm.pedido.pagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorTotal;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pagamento_formaPagamento",
            joinColumns = {@JoinColumn(name = "pagamento_id", foreignKey = @ForeignKey(name = "PAGAMENTO_FK"))},
            inverseJoinColumns = {@JoinColumn(name = "formaPagamento_id", foreignKey = @ForeignKey(name = "FORMA_PAGAMENTO_FK"))})
    private List<FormaPagamento> formasPagamento;
}
