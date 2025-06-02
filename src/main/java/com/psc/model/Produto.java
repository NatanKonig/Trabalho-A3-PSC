package com.psc.model;

public class Produto {
    private int id;
    private String nome;
    private double precoUnitario;
    private String unidade;
    private int quantidadeEstoque;
    private int quantidadeMinima;
    private int quantidadeMaxima;
    private String id_categoria;

    //Construtores
    public Produto(int id, String nome, double precoUnitario,  String id_categoria, int quantidadeEstoque, int quantidadeMinima, int quantidadeMaxima1) {}

    public Produto(int id, String nome, double precoUnitario, String unidade, int quantidadeEstoque, int quantidadeMinima, int quantidadeMaxima, String id_categoria) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
        this.id_categoria = id_categoria;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    // Método para imprimir o produto como texto
    public String toString() {
        return "Id:" + id + "Nome:" + nome + "Preço por unidade" + precoUnitario + unidade;
    }
}
