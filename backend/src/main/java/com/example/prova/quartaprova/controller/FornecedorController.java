package com.example.prova.quartaprova.controller;


import com.example.prova.quartaprova.dto.FornecedorDTO;
import com.example.prova.quartaprova.model.Fornecedor;
import com.example.prova.quartaprova.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<?> listarFornecedores(){
        List<FornecedorDTO> fornecedoresDTO = FornecedorDTO.toDTOs(fornecedorService.listarFornecedores());

        return new ResponseEntity<>(fornecedoresDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retornarFornecedor(@PathVariable("id") Long id){
        FornecedorDTO fornecedorDTO = FornecedorDTO.toDTO(fornecedorService.getFornecedorById(id));

        return new ResponseEntity<>(fornecedorDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> criarFornecedor(@RequestBody FornecedorDTO fornecedorDTO){
        Fornecedor fornecedor = FornecedorDTO.toEntity(fornecedorDTO);
        FornecedorDTO fornecedorCriadoDTO = FornecedorDTO.toDTO(fornecedorService.criarFornecedor(fornecedor));

        return new ResponseEntity<>(fornecedorCriadoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerFornecedores(@PathVariable("id") Long id) {
        fornecedorService.removerFornecedor(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFornecedor(@PathVariable("id") Long id, @RequestBody FornecedorDTO fornecedorDTO){
        Fornecedor fornecedor = FornecedorDTO.toEntity(fornecedorDTO);
        FornecedorDTO fornecedorAtualizadoDTO = FornecedorDTO.toDTO(fornecedorService.atualizarFornecedor(id, fornecedor));

        return new ResponseEntity<>(fornecedorAtualizadoDTO, HttpStatus.OK);
    }



}
