package com.example.prova.quartaprova.controller;

import com.example.prova.quartaprova.model.TipoProduto;
import com.example.prova.quartaprova.repository.TipoProdutoRepository;
import com.example.prova.quartaprova.service.TipoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/api/tipoproduto")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoService tserv;

    @Autowired
    private TipoProdutoRepository trep;

    @GetMapping
    public List<TipoProduto> listarTiposProduto() {
        return tserv.ListaTipoProdutos();
    }

    @GetMapping(value = "/{tipoId}")
    public ResponseEntity<TipoProduto> buscarTipoProdutoById(@PathVariable Long tipoId) {
        TipoProduto obj = tserv.ListaTipoProdutoById(tipoId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<TipoProduto> cadastraTipoProduto(@RequestBody TipoProduto tp){
        tp = tserv.CadastraTipoProduto(tp);
        return ResponseEntity.ok().body(tp);
    }

    @PutMapping(value = "/{tipoId}")
    public ResponseEntity<TipoProduto> alteraTipoProduto(@RequestBody TipoProduto tp, @PathVariable Long tipoId) {
        tp = tserv.AlteraTipoProduto(tipoId, tp);
        return ResponseEntity.ok().body(tp);
    }

    @DeleteMapping(value = "/{tipoId}")
    public ResponseEntity<Void> deletaTipoProduto(@PathVariable Long tipoId) {
        tserv.DeletaTipoProduto(tipoId);
        return ResponseEntity.noContent().build();
    }
}
