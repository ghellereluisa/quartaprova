package com.example.prova.quartaprova.service;

import com.example.prova.quartaprova.model.Fornecedor;
import java.util.List;

public interface FornecedorService {
    Fornecedor getFornecedorById(Long id);

    Fornecedor criarFornecedor(Fornecedor fornecedor);

    void removerFornecedor(Long id);

    Fornecedor atualizarFornecedor(Long id, Fornecedor novoFornecedor);

    List<Fornecedor> listarFornecedores();
}
