package com.psc.dao;

import com.psc.model.Movimentacao;
import com.psc.model.Produto;
import com.psc.model.TipoMovimentacao;

import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDAO {

    //Lista em memória
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    public void registrarMovimentacao(Movimentacao mov) {
        Produto produto = mov.getProduto();

        // Atualiza estoque conforme tipo
        if (mov.getTipo() == TipoMovimentacao.ENTRADA) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + mov.getQuantidade());
        } else if (mov.getTipo() == TipoMovimentacao.SAIDA) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - mov.getQuantidade());
        }

        movimentacoes.add(mov); // salva na lista

        verificarLimites(produto);
    }

    public List<Movimentacao> listarMovimentacoes() {
        return movimentacoes;
    }
//verefica o estoque e exibe mensagens de alerta
    private void verificarLimites(Produto produto) {
        int estoque = produto.getQuantidadeEstoque();
        int minimo = produto.getQuantidadeMinima();
        int maximo = produto.getQuantidadeMaxima();

        if (estoque < minimo) {
            System.out.println("⚠️ Estoque de \"" + produto.getNome() + "\" abaixo do mínimo (" + estoque + "/" + minimo + ")");
        } else if (estoque > maximo) {
            System.out.println("⚠️ Estoque de \"" + produto.getNome() + "\" acima do máximo (" + estoque + "/" + maximo + ")");
        }
    }
}





