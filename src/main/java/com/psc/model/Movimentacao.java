package com.psc.model;

import java.time.LocalDateTime;

import com.psc.model.Produto;
        
public class Movimentacao {
    private int id;
    private Produto produto;
    private int quantidade;
    private TipoMovimentacao tipo;
    private LocalDateTime data;
    
    public Movimentacao(){
        this.data = LocalDateTime.now();
    }
    
    public Movimentacao(int id, Produto produto, int quantidade, TipoMovimentacao tipo, LocalDateTime data){
       this.id = id;
       this.produto = produto;
       this.quantidade = quantidade;
       this.tipo = tipo;
       this.data = data;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public TipoMovimentacao getTipo(){
        return tipo;
    }
    public void setTipo(TipoMovimentacao tipo){
        this.tipo = tipo;
    }
    public  LocalDateTime getData(){
        return data;
    }
    public void setData(LocalDateTime data){
        this.data = data;
    }
    
    @Override
    public String toString(){
        return "Movimentacao{" +
                "id=" + id +
                ", produto=" + (produto != null ? produto.getNome() : "null") +
                ", quantidade=" + quantidade +
                ", tipo=" + tipo +
                ", data=" + data +
                '}';
    }  
    }