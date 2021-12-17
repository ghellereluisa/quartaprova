package com.example.prova.quartaprova.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estoqueId;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "estoque_id" , cascade = CascadeType.ALL)
    private List<Produto> produto = new ArrayList<>();

    public Estoque(Long id, String nome) {
        this.estoqueId = id;
        this.nome = nome;
    }

    public Long getTipoId() {
        return estoqueId;
    }

    public void setTipoId(Long tipoId) {
        this.estoqueId = tipoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProduto() {
        return produto;
    }
}
