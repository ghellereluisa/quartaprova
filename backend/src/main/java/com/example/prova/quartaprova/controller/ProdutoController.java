package com.example.prova.quartaprova.controller;

;
import com.example.prova.quartaprova.dto.ProdutoDTO;
import com.example.prova.quartaprova.dto.ProdutoEstoqueDTO;
import com.example.prova.quartaprova.model.Fornecedor;
import com.example.prova.quartaprova.model.Produto;
import com.example.prova.quartaprova.model.TipoProduto;
import com.example.prova.quartaprova.service.FornecedorService;
import com.example.prova.quartaprova.service.ProdutoService;
import com.example.prova.quartaprova.service.TipoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    FornecedorService fornecedorService;

    @Autowired
    TipoProdutoService tipoProdutoService;

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> criarProduto (@RequestBody ProdutoDTO produtoDTO) {
        Fornecedor fornecedor = fornecedorService.getFornecedorById(produtoDTO.getFornecedorId());
        TipoProduto tipoProduto = tipoProdutoService.getTipoProdutoById(produtoDTO.getTipoProdutoId());

        Produto produto = ProdutoDTO.toEntity(produtoDTO);
        produto.setFornecedor(fornecedor);
        produto.setTipo(tipoProduto);

        ProdutoDTO produtoCriadoDTO = ProdutoDTO.toDTO(produtoService.criarProduto(produto));

        return new ResponseEntity<>(produtoCriadoDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listarProdutos () {
        List<ProdutoDTO> produtosDTO = ProdutoDTO.toDTOs(produtoService.listarProdutos());

        return new ResponseEntity<>(produtosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retornarProduto (@PathVariable("id") Long id) {
        ProdutoDTO produtoDTO = ProdutoDTO.toDTO(produtoService.getProdutoById(id));

        return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerProduto (@PathVariable("id") Long id) {
        produtoService.removerProduto(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable("id") Long id, @RequestBody ProdutoDTO produtoDTO){
        Fornecedor fornecedor = fornecedorService.getFornecedorById(produtoDTO.getFornecedorId());
        TipoProduto tipoProduto = tipoProdutoService.getTipoProdutoById(produtoDTO.getTipoProdutoId());

        Produto produto = ProdutoDTO.toEntity(produtoDTO);
        produto.setFornecedor(fornecedor);
        produto.setTipo(tipoProduto);

        ProdutoDTO produtoAtualizadoDTO = ProdutoDTO.toDTO(produtoService.atualizarProduto(id, produto));

        return new ResponseEntity<>(produtoAtualizadoDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}/estoque")
    public ResponseEntity<?> atualizarEstoqueProduto(@PathVariable("id") Long id, @RequestBody ProdutoEstoqueDTO produtoEstoqueDTO){
        ProdutoDTO produtoEstoqueAtualizadoDTO = ProdutoDTO.toDTO(produtoService.atualizarEstoqueProduto(id, produtoEstoqueDTO.getQttEstoque()));

        return new ResponseEntity<>(produtoEstoqueAtualizadoDTO, HttpStatus.OK);
    }

}
