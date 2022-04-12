package com.example.brejaapi.domain.orm.cliente;

import com.example.brejaapi.domain.orm.Cupom;
import com.example.brejaapi.domain.orm.Troca;
import com.example.brejaapi.domain.orm.pedido.Pedido;
import com.fasterxml.jackson.annotation.*;
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
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String classificacao;
    private String email;
    private String senha;
    private String telefone;
    private String dataNascimento;
    private String genero;
    private String status;
    private LocalDate dataCadastro = LocalDate.now();

    public Cliente(Long id, String nomeCompleto, String cpf, String classificacao, String email, String telefone, String dataNascimento, String genero, String status) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.classificacao = classificacao;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.status = status;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_id")
    private List<Cartao> cartoes;

    @JsonIgnoreProperties("cliente")
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @OneToMany
    @JoinColumn(name = "cupom_id")
    private List<Cupom> cupoms;

    @OneToMany
    @JoinColumn(name = "troca_id")
    private List<Troca> trocas;



}
