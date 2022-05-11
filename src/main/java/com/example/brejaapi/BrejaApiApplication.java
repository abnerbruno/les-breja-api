package com.example.brejaapi;

import com.example.brejaapi.domain.orm.produto.Categoria;
import com.example.brejaapi.domain.orm.produto.Produto;
import com.example.brejaapi.domain.orm.produto.estoque.EntradaEstoque;
import com.example.brejaapi.domain.orm.produto.estoque.EstoqueProduto;
import com.example.brejaapi.domain.repository.CervejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BrejaApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BrejaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		if (!cr.findById(1L).isPresent()){
			populateProducts();
		}
	}

	@Autowired
	CervejaRepository cr;

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
			cr.save(pr);
		}

	}

}
