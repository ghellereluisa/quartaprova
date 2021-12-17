package com.example.prova.quartaprova.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtoId;
    private String nome;
    private String fornecedor;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;

    @ManyToOne
    @JoinColumn(name = "tipoproduto_tipo_id")
    private TipoProduto tipoproduto;

    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque_id;

    public Produto(Long produtoId, String nome, String fornecedor, int quantidade, double precoCompra, double precoVenda, TipoProduto tipoProduto, Estoque estoque_id){
        this.produtoId =  produtoId;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.tipoproduto = tipoProduto;
        this.estoque_id = estoque_id;
    }

    public Estoque getEstoque_id() {
        return estoque_id;
    }

    public void setEstoque_id(Estoque estoque_id) {
        this.estoque_id = estoque_id;
    }

    public TipoProduto getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(TipoProduto tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }


}
