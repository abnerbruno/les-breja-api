package com.example.brejaapi;

import com.example.brejaapi.domain.orm.cliente.Cartao;
import com.example.brejaapi.domain.orm.cliente.Cliente;
import com.example.brejaapi.domain.orm.cliente.Endereco;
import com.example.brejaapi.domain.orm.produto.Categoria;
import com.example.brejaapi.domain.orm.produto.Produto;
import com.example.brejaapi.domain.orm.produto.estoque.EntradaEstoque;
import com.example.brejaapi.domain.orm.produto.estoque.EstoqueProduto;
import com.example.brejaapi.domain.repository.CervejaRepository;
import com.example.brejaapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BrejaApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BrejaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		if (!clienteRepository.findById(1L).isPresent()){
			populateCliente();
		}

		if (!cervejaRepository.findById(1L).isPresent()){
			populateProducts();
		}
	}

	@Autowired
	CervejaRepository cervejaRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Transactional
	public void populateProducts(){

		/* Lista Categoria Produto*/
		Categoria ct = new Categoria();
		ct.setNome("Artesanal");
		ct.setDescricao("Feita a Mão");

		List<Categoria> categoriaList = new ArrayList<>();
		categoriaList.add(ct);
		/* Lista Categoria Produto*/

		/*Estoque Produto*/
		EstoqueProduto ep = new EstoqueProduto();
		ep.setQuantidadeAtual(10);
		ep.setValorBruto(new BigDecimal("60000.0"));
		/*Estoque Produto*/



		List<Produto> produtoList = new ArrayList<>();

		Produto produto1 = new Produto();
		produto1.setValorDeVenda(new BigDecimal("60.0"));
		produto1.setMargemDeLucro(new BigDecimal(8));
		produto1.setNome("Buffalo - Striploin 500ml");
		produto1.setStatus("Ativo");
		produto1.setNomeFornecedor("Três Lobos");
		produto1.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto1.setPhoto("/img/11.jpg");

		produto1.setEstoqueProduto(ep);
		produto1.setCategorias(categoriaList);
		produtoList.add(produto1);

		/*===================================*/

		Produto produto2 = new Produto();
		produto2.setValorDeVenda(new BigDecimal("70.92"));
		produto2.setMargemDeLucro(new BigDecimal(10));
		produto2.setNome("Bacardi Breezer - Tropical 500ml");
		produto2.setStatus("Ativo");
		produto2.setNomeFornecedor("Três Lobos");
		produto2.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto2.setPhoto("/img/12.jpg");

		produto2.setEstoqueProduto(ep);
		produto2.setCategorias(categoriaList);
		produtoList.add(produto2);

		/*===================================*/

		Produto produto3 = new Produto();

		produto3.setValorDeVenda(new BigDecimal("51.01"));
		produto3.setMargemDeLucro(new BigDecimal(12));
		produto3.setNome("Wine - Gato Negro Cabernet 500ml");
		produto3.setStatus("Ativo");
		produto3.setNomeFornecedor("Três Lobos");
		produto3.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto3.setPhoto("/img/13.jpg");

		produto3.setEstoqueProduto(ep);
		produto3.setCategorias(categoriaList);
		produtoList.add(produto3);

		/*===================================*/

		Produto produto4 = new Produto();

		produto4.setValorDeVenda(new BigDecimal("40.9"));
		produto4.setMargemDeLucro(new BigDecimal(14));
		produto4.setNome("Cabbage - Nappa 500ml");
		produto4.setStatus("Ativo");
		produto4.setNomeFornecedor("Três Lobos");
		produto4.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto4.setPhoto("/img/14.jpg");

		produto4.setEstoqueProduto(ep);
		produto4.setCategorias(categoriaList);
		produtoList.add(produto4);

		/*===================================*/

		Produto produto5 = new Produto();
		produto5.setValorDeVenda(new BigDecimal("30.85"));
		produto5.setMargemDeLucro(new BigDecimal(16));
		produto5.setNome("Sping Loaded Cup Dispenser 500ml");
		produto5.setStatus("Ativo");
		produto5.setNomeFornecedor("Três Lobos");
		produto5.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto5.setPhoto("/img/15.jpg");

		produto5.setEstoqueProduto(ep);
		produto5.setCategorias(categoriaList);
		produtoList.add(produto5);

		/*===================================*/

		Produto produto6 = new Produto();
		produto6.setValorDeVenda(new BigDecimal("82.61"));
		produto6.setMargemDeLucro(new BigDecimal(18));
		produto6.setNome("Bread - Malt 500ml");
		produto6.setStatus("Ativo");
		produto6.setNomeFornecedor("Três Lobos");
		produto6.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto6.setPhoto("/img/16.jpg");

		produto6.setEstoqueProduto(ep);
		produto6.setCategorias(categoriaList);
		produtoList.add(produto6);

		/*===================================*/

		Produto produto7 = new Produto();
		produto7.setValorDeVenda(new BigDecimal("60.1"));
		produto7.setMargemDeLucro(new BigDecimal(20));
		produto7.setNome("Glass Clear 8 Oz 500ml");
		produto7.setStatus("Ativo");
		produto7.setNomeFornecedor("Três Lobos");
		produto7.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto7.setPhoto("/img/17.jpg");

		produto7.setEstoqueProduto(ep);
		produto7.setCategorias(categoriaList);
		produtoList.add(produto7);

		/*===================================*/

		Produto produto8 = new Produto();
		produto8.setValorDeVenda(new BigDecimal("80.99"));
		produto8.setMargemDeLucro(new BigDecimal(22));
		produto8.setNome("Sour Puss Raspberry 500ml");
		produto8.setStatus("Ativo");
		produto8.setNomeFornecedor("Três Lobos");
		produto8.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto8.setPhoto("/img/18.jpg");

		produto8.setEstoqueProduto(ep);
		produto8.setCategorias(categoriaList);
		produtoList.add(produto8);

		/*===================================*/

		Produto produto9 = new Produto();
		produto9.setValorDeVenda(new BigDecimal("50.16"));
		produto9.setMargemDeLucro(new BigDecimal(24));
		produto9.setNome("Pork - Chop, Frenched 500ml");
		produto9.setStatus("Ativo");
		produto9.setNomeFornecedor("Três Lobos");
		produto9.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto9.setPhoto("/img/19.jpg");

		produto9.setEstoqueProduto(ep);
		produto9.setCategorias(categoriaList);
		produtoList.add(produto9);

		/*===================================*/

		Produto produto10 = new Produto();

		produto10.setValorDeVenda(new BigDecimal("110.82"));
		produto10.setMargemDeLucro(new BigDecimal(26));
		produto10.setNome("Bagels Poppyseed 500ml");
		produto10.setStatus("Ativo");
		produto10.setNomeFornecedor("Três Lobos");
		produto10.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto10.setPhoto("/img/20.jpg");

		produto10.setEstoqueProduto(ep);
		produto10.setCategorias(categoriaList);
		produtoList.add(produto10);

		/*===================================*/

		for(Produto pr : produtoList){
			pr.getCategorias().get(0).setId(null);
			pr.getEstoqueProduto().setId(null);
			cervejaRepository.save(pr);
		}

	}

	@Transactional
	public void populateCliente(){

		Cliente cliente = new Cliente();
		cliente.setNomeCompleto("Bruno Abner Silva Santos");
		cliente.setCpf("477.987.408-48");
		cliente.setClassificacao("Rank B");
		cliente.setEmail("brunoabner@gmail.com");
		cliente.setSenha("12345");
		cliente.setTelefone("11 97123-0887");
		cliente.setDataNascimento("02-08-1999");
		cliente.setGenero("Masculino");
		cliente.setStatus("Ativo");

		List<Endereco> enderecoList = new ArrayList<>();

		Endereco end1 = new Endereco();
		end1.setLongadouro("Rua Salvador Rugiero");
		end1.setTipoLongadouro("Residencia");
		end1.setTipoResidencia("Residencia");
		end1.setNumero("19");
		end1.setBairro("Vila Maluf");
		end1.setCidade("Suzano");
		end1.setEstado("Sao Paulo");
		end1.setCep("08685-060");
		end1.setPais("Brasil");
		end1.setDescricao("Casa");

		Endereco end2 = new Endereco();
		end2.setLongadouro("Rua MarioCovas");
		end2.setTipoLongadouro("Residencia");
		end2.setTipoResidencia("Residencia");
		end2.setNumero("26");
		end2.setBairro("Vila Orlanda");
		end2.setCidade("Mogi das Cruzes");
		end2.setEstado("Sao Paulo");
		end2.setCep("12345-080");
		end2.setPais("Brasil");
		end2.setDescricao("Empresa");

		enderecoList.add(end1);
		enderecoList.add(end2);

		cliente.setEnderecos(enderecoList);

		List<Cartao> cartaoList = new ArrayList<>();

		Cartao car1 = new Cartao();
		car1.setNomeNoCartao("Bruno Abner da Silva Santos");
		car1.setNumeroCartao("1234567");
		car1.setTipoConta("Poupanca");
		car1.setCodigoSeguranca("123");
		car1.setBandeira("Visa");
		car1.setValidade(new Date());
		car1.setDescricao("Cartão Nubank");

		Cartao car2 = new Cartao();
		car2.setNomeNoCartao("Melissa Oliveira Santos");
		car2.setNumeroCartao("7654321");
		car2.setTipoConta("Poupanca");
		car2.setCodigoSeguranca("321");
		car2.setBandeira("Master Card");
		car2.setValidade(new Date());
		car2.setDescricao("Cartão Neon");

		cartaoList.add(car1);
		cartaoList.add(car2);

		cliente.setCartoes(cartaoList);

		clienteRepository.save(cliente);
	}

}
