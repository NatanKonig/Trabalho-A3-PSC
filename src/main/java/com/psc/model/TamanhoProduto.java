package com.psc.model;

/**
 * Enumeração que representa os tamanhos disponíveis para um produto.
 *
 * <p>Os tamanhos possíveis são:
 * <ul>
 *     <li>{@link #PEQUENO} - tamanho pequeno</li>
 *     <li>{@link #MEDIO} - tamanho médio</li>
 *     <li>{@link #GRANDE} - tamanho grande</li>
 * </ul>
 * </p>
 *
 * <p>Possui uma implementação personalizada de {@code toString()} para exibir nomes mais legíveis.</p>
 *
 * @author AguiarFabricio
 * @version 1.0
 */
public enum TamanhoProduto {
    /**
     * Tamanho pequeno.
     */
    PEQUENO,

    /**
     * Tamanho médio.
     */
    MEDIO,

    /**
     * Tamanho grande.
     */
    GRANDE;

    /**
     * Retorna uma representação amigável do tamanho.
     *
     * @return nome formatado do tamanho
     */
    @Override
    public String toString() {
        switch (this) {
            case PEQUENO:
                return "Pequeno";
            case MEDIO:
                return "Médio";
            case GRANDE:
                return "Grande";
            default:
                return super.toString();
        }
    }
}
