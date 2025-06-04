package com.psc.model;

import java.time.LocalDateTime;

//Classe que representa a movimentação de estoque
public class Movimentacao {
    private int id;
    private int quantidade;
    private TipoMovimentacao tipo; // ENTRADA ou SAIDA
    private LocalDateTime data;
    private Produto produto;

    public Movimentacao() {
    }

    public Movimentacao(int id, int quantidade, TipoMovimentacao tipo, LocalDateTime data, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.data = data;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}

