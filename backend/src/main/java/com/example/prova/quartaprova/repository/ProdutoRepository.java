package com.example.prova.quartaprova.repository;

import com.example.prova.quartaprova.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
