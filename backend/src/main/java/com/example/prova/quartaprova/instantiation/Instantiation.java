package com.example.prova.quartaprova.instantiation;

import com.example.prova.quartaprova.model.Estoque;
import com.example.prova.quartaprova.model.Produto;
import com.example.prova.quartaprova.model.TipoProduto;
import com.example.prova.quartaprova.repository.EstoqueRepository;
import com.example.prova.quartaprova.repository.ProdutoRepository;
import com.example.prova.quartaprova.repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ProdutoRepository prep;

    @Autowired
    private TipoProdutoRepository trep;

    @Autowired
    private EstoqueRepository erep;

    @Override
    public void run(String... args) throws Exception{

        Estoque e1 = new Estoque(null, "bebidas alcoolicas");
        Estoque e2 = new Estoque(null, "cigarros/paieros");
        erep.saveAll(Arrays.asList(e1, e2));

        TipoProduto t1 = new TipoProduto(null, "bebida");
        TipoProduto t2 = new TipoProduto(null, "cigarro");
        trep.saveAll(Arrays.asList(t1, t2));

        Produto p1 = new Produto(null, "Veio Barreiro", "bebida", 1, 5.00, 12.00, t1, e1);
        Produto p2 = new Produto(null, "Corotinho", "bebida", 1, 2000.00, 2200.00, t1, e1);
        Produto p3 = new Produto(null, "Conti", "bebida", 1, 1200.00, 1500.00,t1, e1);
        Produto p4 = new Produto(null, "Malboro", "cigarro", 1, 7.00, 10.50, t2, e2);
        Produto p5 = new Produto(null, "Fox", "cigarro", 1, 1.50, 3.25, t2, e2);
        prep.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
