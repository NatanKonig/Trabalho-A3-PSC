package com.psc.model;

/**
 * Enumeração que representa os tipos de embalagem disponíveis para um produto.
 *
 * <p>Os tipos possíveis são:
 * <ul>
 *     <li>{@link #PLASTICO} - embalagem feita de plástico</li>
 *     <li>{@link #VIDRO} - embalagem feita de vidro</li>
 *     <li>{@link #LATA} - embalagem feita de lata</li>
 * </ul>
 * </p>
 *
 * <p>Possui uma implementação personalizada de {@code toString()} para exibir nomes mais legíveis.</p>
 *
 * @author AguiarFabricio
 * @version 1.0
 */
public enum EmbalagemProduto {
    /**
     * Embalagem feita de plástico.
     */
    PLASTICO,

    /**
     * Embalagem feita de vidro.
     */
    VIDRO,

    /**
     * Embalagem feita de lata.
     */
    LATA;

    /**
     * Retorna uma representação amigável da embalagem.
     *
     * @return nome formatado da embalagem
     */
    @Override
    public String toString() {
        switch (this) {
            case PLASTICO:
                return "Plástico";
            case VIDRO:
                return "Vidro";
            case LATA:
                return "Lata";
            default:
                return super.toString();
        }
    }
}
