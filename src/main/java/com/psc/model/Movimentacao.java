package com.psc.model;

import java.time.LocalDateTime;

/**
 * Representa uma movimentação de estoque para um produto,
 * que pode ser do tipo ENTRADA ou SAIDA, com quantidade, data e identificação.
 *
 * <p>Essa classe encapsula os dados relacionados a uma movimentação de estoque,
 * como a quantidade movimentada, o tipo da movimentação, a data e o produto envolvido.</p>
 *
 * @author EvelynYs2
 * @version 1.0
 */
public class Movimentacao {

    /**
     * Identificador único da movimentação.
     */
    private int id;

    /**
     * Quantidade de unidades movimentadas.
     */
    private int quantidade;

    /**
     * Tipo da movimentação: ENTRADA ou SAIDA.
     */
    private TipoMovimentacao tipo;

    /**
     * Data e hora da movimentação.
     */
    private LocalDateTime data;

    /**
     * Produto relacionado à movimentação.
     */
    private Produto produto;

    /**
     * Construtor padrão da classe Movimentacao.
     */
    public Movimentacao() {
    }

    /**
     * Construtor que inicializa todos os atributos da movimentação.
     *
     * @param id identificador da movimentação
     * @param quantidade quantidade de unidades movimentadas
     * @param tipo tipo da movimentação (ENTRADA ou SAIDA)
     * @param data data e hora da movimentação
     * @param produto produto relacionado à movimentação
     */
    public Movimentacao(int id, int quantidade, TipoMovimentacao tipo, LocalDateTime data, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.data = data;
        this.produto = produto;
    }

    /**
     * Retorna o identificador da movimentação.
     *
     * @return o id da movimentação
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da movimentação.
     *
     * @param id o novo id da movimentação
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a quantidade movimentada.
     *
     * @return a quantidade movimentada
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade movimentada.
     *
     * @param quantidade a nova quantidade movimentada
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o tipo da movimentação (ENTRADA ou SAIDA).
     *
     * @return o tipo da movimentação
     */
    public TipoMovimentacao getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da movimentação.
     *
     * @param tipo o novo tipo da movimentação
     */
    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna a data e hora da movimentação.
     *
     * @return a data e hora da movimentação
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * Define a data e hora da movimentação.
     *
     * @param data a nova data e hora da movimentação
     */
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    /**
     * Retorna o produto relacionado à movimentação.
     *
     * @return o produto da movimentação
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Define o produto relacionado à movimentação.
     *
     * @param produto o novo produto da movimentação
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
