package com.example.brejaapi.domain.orm.pedido.pagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pagamento")
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private String nomeNoCartao;
    private String numeroCartao;
    private Date validade;
    private String codigoSeguranca;
    private String tipoConta;
    private String bandeira;

    private String descricao;
}
