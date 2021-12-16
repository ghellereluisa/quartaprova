package com.example.prova.quartaprova.service;


import com.example.prova.quartaprova.model.TipoProduto;
import java.util.List;

public interface TipoProdutoService {
    TipoProduto getTipoProdutoById(Long id);

    TipoProduto criarTipoProduto(TipoProduto tipoProduto);

    void removerTipoProduto(Long id);

    TipoProduto atualizarTipoProduto(Long id, TipoProduto novoTipoProduto);

    List<TipoProduto> listarTiposProduto();
}
