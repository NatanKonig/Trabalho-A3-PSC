package com.psc.dao;

import java.sql.*;
import java.io.InputStream;
import java.util.Properties;

public class MovimentacaoDAO {

    private String URL;
    private String USER;
    private String PASSWORD;

    public MovimentacaoDAO() {
        carregarConfiguracoes();
    }

    private void carregarConfiguracoes() {
        try {
            Properties props = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("Arquivo config.properties não encontrado no classpath.");
            }

            props.load(input);

            this.URL = props.getProperty("db.url");
            this.USER = props.getProperty("db.user");
            this.PASSWORD = props.getProperty("db.password");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar configurações do banco de dados.", e);
        }
    }

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Movimenta estoque conforme o tipo (Entrada ou Saída)
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

    // Verifica limite de estoque
    private void verificarLimites(String nomeProduto, int estoque, int minimo, int maximo) {
        if (estoque < minimo) {
            System.out.println("⚠️ Estoque de \"" + nomeProduto + "\" abaixo do mínimo (" + estoque + "/" + minimo + ")");
        } else if (estoque > maximo) {
            System.out.println("⚠️ Estoque de \"" + nomeProduto + "\" acima do máximo (" + estoque + "/" + maximo + ")");
        }
    }
}



