package com.example.prova.quartaprova.util;

import com.example.prova.quartaprova.model.Estoque;

public class EstoqueCreator {

    public static Estoque createEstoque() {
        Estoque estoque = new Estoque(1L, "Guitarras Eletricas");
        return estoque;
    }
}

