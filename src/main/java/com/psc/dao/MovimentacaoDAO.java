package com.psc.dao;

import java.sql.*;

public class MovimentacaoDAO {

    private final String URL = "jdbc:mysql://localhost:3306/controle_estoque";
    private final String USER = "root";
    private final String PASSWORD = "Fibi1518+";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

//Movimenta estoque conforme o tipo(Entrada ou Saída)
    public boolean movimentarEstoque(int produtoId, int quantidade, String tipo) {
        try (Connection conn = conectar()) {
            // 1. Buscar a quantidade atual do produto
            String selectSql = "SELECT qtd_estoque, qtd_minima, qtd_maxima, nome FROM produto WHERE id_produto = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setInt(1, produtoId);
            ResultSet rs = selectStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Produto não encontrado.");
                return false;
            }

            int quantidadeAtual = rs.getInt("qtd_estoque");
            int qtdMinima = rs.getInt("qtd_minima");
            int qtdMaxima = rs.getInt("qtd_maxima");
            String nomeProduto = rs.getString("nome");

            int novaQuantidade;

            // 2. Calcula nova quantidade
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
            String updateSql = "UPDATE produto SET qtd_estoque = ? WHERE id_produto = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setInt(1, novaQuantidade);
            updateStmt.setInt(2, produtoId);
            updateStmt.executeUpdate();

            // Verifica limites após movimentação
            verificarLimites(nomeProduto, novaQuantidade, qtdMinima, qtdMaxima);

            System.out.println("Estoque atualizado com sucesso!");
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao movimentar estoque: " + e.getMessage());
            return false;
        }
    }

//Verifica limte de estoque
    private void verificarLimites(String nomeProduto, int estoque, int minimo, int maximo) {
        if (estoque < minimo) {
            System.out.println("⚠️ Estoque de \"" + nomeProduto + "\" abaixo do mínimo (" + estoque + "/" + minimo + ")");
        } else if (estoque > maximo) {
            System.out.println("⚠️ Estoque de \"" + nomeProduto + "\" acima do máximo (" + estoque + "/" + maximo + ")");
        }
    }
}


