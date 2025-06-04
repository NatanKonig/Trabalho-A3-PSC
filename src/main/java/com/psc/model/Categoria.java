package com.psc.model;

/**
 * Representa uma categoria de produto, contendo identificador, nome, tamanho e embalagem.
 *
 * <p>Utilizada para classificar produtos de acordo com características como tamanho e tipo de embalagem.</p>
 *
 * @author AguiarFabricio
 * @version 1.0
 */
public class Categoria {

    /**
     * Identificador único da categoria.
     */
    private int id;

    /**
     * Nome descritivo da categoria.
     */
    private String nome;

    /**
     * Tamanho associado à categoria (por exemplo, pequeno, médio, grande).
     */
    private TamanhoProduto tamanho;

    /**
     * Tipo de embalagem associado à categoria (por exemplo, caixa, saco, vidro).
     */
    private EmbalagemProduto embalagem;

    /**
     * Construtor padrão que inicializa uma categoria sem definir valores.
     * <p>Necessário para frameworks que utilizam reflexão ou criação de instância sem parâmetros.</p>
     */
    public Categoria() {
    }

    /**
     * Construtor que inicializa todos os atributos da categoria.
     *
     * @param id        identificador único da categoria
     * @param nome      nome descritivo da categoria
     * @param tamanho   tamanho do produto associado a essa categoria
     * @param embalagem tipo de embalagem associado a essa categoria
     */
    public Categoria(int id, String nome, TamanhoProduto tamanho, EmbalagemProduto embalagem) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    /**
     * Construtor que inicializa apenas o identificador e o nome da categoria.
     * <p>Utilizado quando apenas ID e nome são necessários, sem detalhes de tamanho ou embalagem.</p>
     *
     * @param idCategoria   identificador único da categoria
     * @param nomeCategoria nome descritivo da categoria
     */
    public Categoria(int idCategoria, String nomeCategoria) {
        this.id = idCategoria;
        this.nome = nomeCategoria;
    }

    /**
     * Retorna o identificador da categoria.
     *
     * @return id único da categoria
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da categoria.
     *
     * @param id novo id a ser atribuído à categoria
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome descritivo da categoria.
     *
     * @return nome da categoria
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome descritivo da categoria.
     *
     * @param nome novo nome a ser atribuído à categoria
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o tamanho do produto associado a esta categoria.
     *
     * @return tamanho do produto
     */
    public TamanhoProduto getTamanho() {
        return tamanho;
    }

    /**
     * Define o tamanho do produto associado a esta categoria.
     *
     * @param tamanho novo tamanho a ser atribuído
     */
    public void setTamanho(TamanhoProduto tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Retorna o tipo de embalagem associado a esta categoria.
     *
     * @return tipo de embalagem
     */
    public EmbalagemProduto getEmbalagem() {
        return embalagem;
    }

    /**
     * Define o tipo de embalagem associado a esta categoria.
     *
     * @param embalagem nova embalagem a ser atribuída
     */
    public void setEmbalagem(EmbalagemProduto embalagem) {
        this.embalagem = embalagem;
    }

    /**
     * Retorna uma representação em texto da categoria no formato "id - nome".
     *
     * @return string contendo o id e o nome da categoria
     */
    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
