package com.psc.model;

/**
 * Representa um produto no sistema, com informações como nome, preço, unidade de medida,
 * quantidades de estoque (atual, mínima e máxima) e categoria.
 *
 * <p>Essa classe encapsula os dados principais de um produto, permitindo
 * manipulação e consulta de suas propriedades.</p>
 *
 * @author Machadox18
 * @version 1.0
 */
public class Produto {

    /**
     * Identificador único do produto.
     */
    private int id;

    /**
     * Nome do produto.
     */
    private String nome;

    /**
     * Preço unitário do produto.
     */
    private double precoUnitario;

    /**
     * Unidade de medida utilizada (ex.: "kg", "un", "l").
     */
    private String unidade;

    /**
     * Quantidade atual disponível em estoque.
     */
    private int quantidadeEstoque;

    /**
     * Quantidade mínima que deve existir em estoque antes de um alerta.
     */
    private int quantidadeMinima;

    /**
     * Quantidade máxima permitida em estoque.
     */
    private int quantidadeMaxima;

    /**
     * Categoria à qual o produto pertence.
     */
    private Categoria categoria;


    /**
     * Construtor padrão que inicializa um produto sem definir valores.
     */
    public Produto() {
    }

    /**
     * Construtor que inicializa todos os atributos do produto.
     *
     * @param id                identificador único do produto
     * @param nome              nome do produto
     * @param precoUnitario     preço unitário do produto
     * @param unidade           unidade de medida do produto
     * @param quantidadeEstoque quantidade atual em estoque
     * @param quantidadeMinima  quantidade mínima em estoque
     * @param quantidadeMaxima  quantidade máxima em estoque
     * @param categoria         categoria do produto
     */
    public Produto(int id, String nome, double precoUnitario, String unidade,
                   int quantidadeEstoque, int quantidadeMinima,
                   int quantidadeMaxima, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
        this.categoria = categoria;
    }


    /**
     * Retorna o identificador do produto.
     *
     * @return id do produto
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do produto.
     *
     * @param id novo id do produto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome novo nome do produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o preço unitário do produto.
     *
     * @return preço unitário
     */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * Define o preço unitário do produto.
     *
     * @param precoUnitario novo preço unitário
     */
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    /**
     * Retorna a unidade de medida do produto.
     *
     * @return unidade de medida
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * Define a unidade de medida do produto.
     *
     * @param unidade nova unidade de medida
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * Retorna a quantidade atual em estoque.
     *
     * @return quantidade em estoque
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * Define a quantidade atual em estoque.
     *
     * @param quantidadeEstoque nova quantidade em estoque
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * Retorna a quantidade mínima no estoque antes de alertar baixo estoque.
     *
     * @return quantidade mínima em estoque
     */
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    /**
     * Define a quantidade mínima no estoque antes de alertar baixo estoque.
     *
     * @param quantidadeMinima nova quantidade mínima em estoque
     */
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    /**
     * Retorna a quantidade máxima permitida em estoque.
     *
     * @return quantidade máxima em estoque
     */
    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    /**
     * Define a quantidade máxima permitida em estoque.
     *
     * @param quantidadeMaxima nova quantidade máxima em estoque
     */
    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    /**
     * Retorna a categoria do produto.
     *
     * @return categoria do produto
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do produto.
     *
     * @param categoria nova categoria do produto
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna a representação em texto do produto, que corresponde ao seu nome.
     *
     * @return nome do produto
     */
    @Override
    public String toString() {
        return nome;
    }
}
