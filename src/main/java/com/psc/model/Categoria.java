package com.psc.model;

public class Categoria {

    private String nome;
    private TamanhoProduto tamanho;
    private EmbalagemProduto embalagem;

    public enum Embalagem {

    }

    public Categoria(String nome, TamanhoProduto tamanho, EmbalagemProduto embalagem) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TamanhoProduto getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoProduto tamanho) {
        this.tamanho = tamanho;
    }

    public EmbalagemProduto getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(EmbalagemProduto embalagem) {
        this.embalagem = embalagem;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + nome + '\'' +
                ", tamanho=" + tamanho +
                ", embalagem=" + embalagem +
                '}';
    }
}
