package com.example.brejaapi;

import com.example.brejaapi.domain.orm.produto.Categoria;
import com.example.brejaapi.domain.orm.produto.estoque.EntradaEstoque;
import com.example.brejaapi.domain.orm.produto.estoque.EstoqueProduto;
import com.example.brejaapi.domain.orm.produto.Produto;
import com.example.brejaapi.domain.repository.CervejaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BrejaApiApplicationTests {

	@Autowired
	CervejaRepository cr;

	@Test
	void contextLoads() {
		Produto produto1 = new Produto();
		produto1.setValorDeVenda(new BigDecimal("60.0"));
		produto1.setMargemDeLucro(new BigDecimal(8));
		produto1.setNome("Buffalo - Striploin 500ml");
		produto1.setStatus("Ativo");
		produto1.setNomeFornecedor("Três Lobos");
		produto1.setDescricao("As cervejas artesanais são elaboradas por meio de um processo mais\n" +
				"cuidadoso, com foco em qualidade");
		produto1.setPhoto("/img/11.jpg");

		/*Estoque Produto*/
		EstoqueProduto ep = new EstoqueProduto();
		ep.setQuantidadeAtual(10);
		ep.setValorBruto(new BigDecimal("60.0"));
		produto1.setEstoqueProduto(ep);
		/*Estoque Produto*/

		/*Lista Categoria*/
		Categoria ct = new Categoria();
		ct.setNome("Artesanal");
		ct.setDescricao("Feita a Mão");

		List<Categoria> lc = new ArrayList<>();
		lc.add(ct);
		produto1.setCategorias(lc);
		/*Lista Categoria*/

		/*Lista Entradas ao Estoque*/
		List<EntradaEstoque> les = new ArrayList<>();

		EntradaEstoque es = new EntradaEstoque();
		es.setQuantidade(10);
		es.setEstoqueProduto(ep);

		les.add(es);

		produto1.setEntradasEstoque(les);
		/*Lista Entradas ao Estoque*/



		cr.save(produto1);
	}

}
