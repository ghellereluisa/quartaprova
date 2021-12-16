package com.example.prova.quartaprova.service.implementation;


import com.example.prova.quartaprova.model.Produto;
import com.example.prova.quartaprova.repository.ProdutoRepository;
import com.example.prova.quartaprova.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto getProdutoById (Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoExisteException(id));
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos () {
        return produtoRepository.findAll();
    }

    public void removerProduto (Long id) {
        Produto produto = getProdutoById(id);
        produtoRepository.delete(produto);
    }

    public Produto atualizarProduto (Long id, Produto produto) {
        Produto produtoNovo = getProdutoById(id);

        produtoNovo.setTipo(produto.getTipo());
        produtoNovo.setFornecedor(produto.getFornecedor());
        produtoNovo.setNome(produto.getNome());
        produtoNovo.setPrecoCompra(produto.getPrecoCompra());
        produtoNovo.setPrecoVenda(produto.getPrecoVenda());

        return produtoRepository.save(produtoNovo);

    }

    public Produto atualizarEstoqueProduto (Long id, Long novoEstoque) {
        Produto produto = getProdutoById(id);

        produto.setQttEstoque(novoEstoque);

        return produtoRepository.save(produto);

    }
}