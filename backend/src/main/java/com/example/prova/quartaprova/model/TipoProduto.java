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
@Table(name = "tipoproduto")
public class TipoProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoId;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoproduto" , cascade = CascadeType.ALL)
    private List<Produto> produto = new ArrayList<>();

    public TipoProduto(Long tipoId, String nome){
        this.tipoId = tipoId;
        this.nome = nome;
    }

    public Long getTipoId() {
        return tipoId;
    }

    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produto;
    }
}
