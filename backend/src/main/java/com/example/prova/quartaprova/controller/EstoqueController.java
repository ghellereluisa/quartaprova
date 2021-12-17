package com.example.prova.quartaprova.controller;

import com.example.prova.quartaprova.model.Estoque;
import com.example.prova.quartaprova.repository.EstoqueRepository;
import com.example.prova.quartaprova.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService eserv;

    @Autowired
    private EstoqueRepository erep;

    @GetMapping
    public List<Estoque> listaEstoques() {
        return eserv.ListaEstoque();
    }

    @GetMapping(value = "/{estoqueId}")
    public ResponseEntity<Estoque> buscaEstoqueById(@PathVariable Long estoqueId) {
        Estoque obj = eserv.ListaEstoqueById(estoqueId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Estoque> cadastraEstoque(@RequestBody Estoque estoque) {
        estoque = eserv.CadastraEstoque(estoque);
        return ResponseEntity.ok().body(estoque);
    }

    @PutMapping(value = "/{estoqueId}")
    public ResponseEntity<Estoque> alteraEstoque(@RequestBody Estoque estoque, @PathVariable Long estoqueId) {
        estoque = eserv.AlteraEstoque(estoqueId, estoque);
        return ResponseEntity.ok().body(estoque);
    }

    @DeleteMapping(value = "/{estoqueId}")
    public ResponseEntity<Void> deletaEstoque(@PathVariable Long estoqueId) {
        eserv.DeletaEstoque(estoqueId);
        return ResponseEntity.noContent().build();
    }
}
