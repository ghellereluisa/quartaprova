package com.example.prova.quartaprova.service.implementation;

import com.example.prova.quartaprova.exception.FornecedorExistenteException;
import com.example.prova.quartaprova.exception.FornecedorNaoExisteException;
import com.example.prova.quartaprova.model.Fornecedor;
import com.example.prova.quartaprova.repository.FornecedorRepository;
import com.example.prova.quartaprova.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor getFornecedorById(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(() -> new FornecedorNaoExisteException(id));
    }

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        if (fornecedorRepository.existsByCnpj(fornecedor.getCnpj())) {
            throw new FornecedorExistenteException(fornecedor.getCnpj());
        }

        return fornecedorRepository.save(fornecedor);
    }

    public void removerFornecedor(Long id) {
        Fornecedor fornecedor = getFornecedorById(id);

        fornecedorRepository.delete(fornecedor);
    }

    public Fornecedor atualizarFornecedor(Long id, Fornecedor novoFornecedor) {
        Fornecedor fornecedor = getFornecedorById(id);
        fornecedor.setNome(novoFornecedor.getNome());
        fornecedor.setCnpj(novoFornecedor.getCnpj());
        fornecedor.setEndereco(novoFornecedor.getEndereco());
        fornecedor.setTelefones(novoFornecedor.getTelefones());
        fornecedor.setEmails(novoFornecedor.getEmails());

        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarFornecedores(){
        return fornecedorRepository.findAll();
    }

}
