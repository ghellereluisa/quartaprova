package com.example.prova.quartaprova.controller;

import com.example.prova.quartaprova.model.Produto;
import com.example.prova.quartaprova.repository.ProdutoRepository;
import com.example.prova.quartaprova.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService pserv;

    @Autowired
    private ProdutoRepository prep;

    @GetMapping
    public List<Produto> listarProtutos() {
        return pserv.ListaProdutos();
    }

    @GetMapping(value = "/{produtoId}")
    public ResponseEntity<Produto> buscaProdutoById(@PathVariable Long produtoId) {
        Produto obj = pserv.ListProdutoByid(produtoId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastraProduto(@RequestBody Produto produto) {
        produto = pserv.CadastraProduto(produto);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping(value ="/{produtoId}")
    public ResponseEntity<Produto> alteraProduto(@RequestBody Produto produto, @PathVariable Long produtoId) {
        produto = pserv.AlteraProduto(produtoId, produto);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping(value = "/{produtoId}")
    public ResponseEntity<Void> deletaProduto(@PathVariable Long produtoId) {
        pserv.DeletaProduto(produtoId);
        return ResponseEntity.noContent().build();
    }



}
