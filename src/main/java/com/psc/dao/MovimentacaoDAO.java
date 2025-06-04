package com.psc.dao;

import com.psc.model.Movimentacao;
import com.psc.model.Produto;
import com.psc.model.TipoMovimentacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MovimentacaoDAO {

    // Método que movimenta o estoque e registra a movimentação
    public boolean movimentarEstoque(Produto produto, int quantidade, TipoMovimentacao tipo, String dataStr) {
        boolean estoqueAtualizado = atualizarEstoque(produto, quantidade, tipo);

        if (!estoqueAtualizado) {
            System.out.println("Erro ao atualizar o estoque.");
            return false;
        }

        // Definir data
        LocalDateTime data;
        if (dataStr != null && !dataStr.isEmpty()) {
            data = LocalDateTime.parse(dataStr);
        } else {
            data = LocalDateTime.now();
        }

        Movimentacao movimentacao = new Movimentacao(0, quantidade, tipo, data, produto);

        // 3. Inserir movimentação
        return inserir(movimentacao);
    }

    // Método privado para atualizar a quantidade de estoque
    private boolean atualizarEstoque(Produto produto, int quantidade, TipoMovimentacao tipo) {
        String sql = "";

        if (tipo == TipoMovimentacao.ENTRADA) {
            sql = "UPDATE produto SET qtd_estoque = qtd_estoque + ? WHERE id_produto = ?";
        } else if (tipo == TipoMovimentacao.SAIDA) {
            sql = "UPDATE produto SET qtd_estoque = qtd_estoque - ? WHERE id_produto = ?";
        } else {
            System.out.println("Tipo inválido: " + tipo);
            return false;
        }

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, quantidade);
            stmt.setInt(2, produto.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para inserir a movimentação no banco de dados
    public boolean inserir(Movimentacao movimentacao) {
        String sql = "INSERT INTO movimentacao (id_produto, quantidade_movimentada, tipo_movimentacao, data) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, movimentacao.getProduto().getId());
            stmt.setInt(2, movimentacao.getQuantidade());
            stmt.setString(3, movimentacao.getTipo().toString());
            stmt.setTimestamp(4, Timestamp.valueOf(movimentacao.getData()));

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
