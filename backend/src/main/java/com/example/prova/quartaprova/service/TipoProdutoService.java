package com.example.prova.quartaprova.service;

import com.example.prova.quartaprova.model.TipoProduto;
import com.example.prova.quartaprova.repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProdutoService {

    @Autowired
    TipoProdutoRepository trep;

    public List<TipoProduto> ListaTipoProdutos() {
        return trep.findAll();
    }

    public TipoProduto ListaTipoProdutoById(Long tipoProdutoId) {
        Optional<TipoProduto> obj = trep.findById(tipoProdutoId);
        return obj.get();
    }

    public TipoProduto CadastraTipoProduto(TipoProduto tipoProduto) {
        return trep.save(tipoProduto);
    }

    public void DeletaTipoProduto(Long tipoProdutoId) {
        trep.deleteById(tipoProdutoId);
    }

    public TipoProduto AlteraTipoProduto(Long tipoProdutoId, TipoProduto obj) {
        TipoProduto entity = trep.findById(tipoProdutoId).get();
        UpdateData(entity, obj);
        return trep.save(entity);
    }

    private void UpdateData(TipoProduto entity, TipoProduto obj) {
        entity.setNome(obj.getNome());
    }
}
