package com.example.prova.quartaprova;

import com.example.prova.quartaprova.model.Produto;
import com.example.prova.quartaprova.model.TipoProduto;
import com.example.prova.quartaprova.repository.ProdutoRepository;
import com.example.prova.quartaprova.repository.TipoProdutoRepository;
import com.example.prova.quartaprova.util.EstoqueCreator;
import com.example.prova.quartaprova.util.ProdutoCreator;
import com.example.prova.quartaprova.util.TipoProdutoCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuartaprovaApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private ProdutoRepository prep;

	@Autowired
	private TipoProdutoRepository trep;

	@Test
	void criaProdutoInvalido_deveRetornarErro() {
		Produto produto =  new Produto(1L, null, "Tagima", 1, 750.00, 800.00, TipoProdutoCreator.createTipoProduto(), EstoqueCreator.createEstoque());

		ResponseEntity<Produto> resp = this.testRestTemplate
				.postForEntity("http://localhost:" + port + "/produtos", produto, Produto.class);

		Assertions.assertThat(resp.getBody().getNome()).isNull();
		Assertions.assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Test
	void tentaCriarProdutoEtipoProduto_deveRetornarHttpStatusUnauthorized() {
		Produto produto = ProdutoCreator.createValidProduct();
		TipoProduto expectedTipoProduto = TipoProdutoCreator.createTipoProduto();

		ResponseEntity<Produto> resp = this.testRestTemplate
				.postForEntity("http://localhost:" + port + "/produtos", produto, Produto.class);
		ResponseEntity<TipoProduto> respT = this.testRestTemplate
				.postForEntity("http://localhost:" + port + "/tipoproduto", expectedTipoProduto, TipoProduto.class);

		Assertions.assertThat(resp).isNotNull();
		Assertions.assertThat(respT).isNotNull();
		Assertions.assertThat(resp.getBody().getTipoproduto().getNome()).isEqualTo(respT.getBody().getNome());
	}

}
