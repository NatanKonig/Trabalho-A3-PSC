package com.psc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovimentacaoDAO {

    /**
     * Método responsável por movimentar o estoque de um produto.
     * 
     * @param produtoId ID do produto a ser movimentado.
     * @param quantidade Quantidade da movimentação.
     * @param tipo "ENTRADA" ou "SAIDA".
     * @return true se a movimentação foi bem sucedida, false caso contrário.
     */
    public boolean movimentarEstoque(int produtoId, int quantidade, String tipo) {
        try (Connection conn = ConexaoDAO.getConnection()) {   // ✅ AGORA usa ConexaoDAO

            // Consulta a quantidade atual
            String selectSql = "SELECT quantidade_estoque FROM produto WHERE id = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setInt(1, produtoId);
            ResultSet rs = selectStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Produto não encontrado.");
                return false;
            }

            int quantidadeAtual = rs.getInt("quantidade_estoque");
            int novaQuantidade;

            if (tipo.equalsIgnoreCase("ENTRADA")) {
                novaQuantidade = quantidadeAtual + quantidade;
            } else if (tipo.equalsIgnoreCase("SAIDA")) {
                novaQuantidade = quantidadeAtual - quantidade;
                if (novaQuantidade < 0) {
                    System.out.println("Estoque insuficiente para a saída.");
                    return false;
                }
            } else {
                System.out.println("Tipo de movimentação inválido.");
                return false;
            }

            // Atualiza o estoque
            String updateSql = "UPDATE produto SET quantidade_estoque = ? WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setInt(1, novaQuantidade);
            updateStmt.setInt(2, produtoId);
            updateStmt.executeUpdate();

            System.out.println("Estoque atualizado com sucesso. Nova quantidade: " + novaQuantidade);
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao movimentar estoque: " + e.getMessage());
            return false;
        }
    }
}


