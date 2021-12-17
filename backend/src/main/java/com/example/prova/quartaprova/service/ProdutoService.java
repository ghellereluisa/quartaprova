package com.example.prova.quartaprova.service;


import com.example.prova.quartaprova.exception.NamelessProductException;
import com.example.prova.quartaprova.model.Produto;
import com.example.prova.quartaprova.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository prep;

    public List<Produto> ListaProdutos(){
        return prep.findAll();
    }

    public Produto ListProdutoByid(Long produtoId) {
        Optional<Produto> obj = prep.findById(produtoId);
        return obj.get();
    }

    public Produto CadastraProduto(Produto produto) {
        if (produto.getNome().isEmpty()){
            throw new NamelessProductException("Impossível cadastrar um produto sem nome.");
        } else{
            return prep.save(produto);
        }
    }

    public void DeletaProduto(Long produtoId) {
        prep.deleteById(produtoId);
    }

    public Produto AlteraProduto(Long produtoId, Produto obj) {
        Produto entity = prep.findById(produtoId).get();
        UpdateData(entity, obj);
        return prep.save(entity);
    }

    private void UpdateData(Produto entity, Produto obj) {
        entity.setNome(obj.getNome());
        entity.setFornecedor(obj.getFornecedor());
        entity.setPrecoCompra(obj.getPrecoCompra());
        entity.setPrecoVenda(obj.getPrecoVenda());
        entity.setQuantidade(obj.getQuantidade());
    }
}
