package com.example.prova.quartaprova.util;

import com.example.prova.quartaprova.model.Produto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProdutoCreator {

    public static Produto createInvalidProduto() {
        Produto p1 = new Produto(1L, "", "Tagima", 1, 750.00, 800.00, TipoProdutoCreator.createTipoProduto(), EstoqueCreator.createEstoque());
        return p1;
    }

    public static Produto createValidProduct() {
        Produto p1 = new Produto(1L, "Guitarra Memphis", "Tagima", 1, 750.00, 800.00, TipoProdutoCreator.createTipoProduto(), EstoqueCreator.createEstoque());
        return p1;
    }
}