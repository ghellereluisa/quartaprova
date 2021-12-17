package com.example.prova.quartaprova.util;

import com.example.prova.quartaprova.model.TipoProduto;

public class TipoProdutoCreator {

    public static TipoProduto createTipoProduto() {
        TipoProduto tp = new TipoProduto(1L, "Guitarra");
        return tp;
    }
}
