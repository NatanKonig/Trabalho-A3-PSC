package com.psc.dao;


import com.psc.model.Movimentacao;
import com.psc.model.Produto;
import com.psc.model.TipoMovimentacao;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDAO {

    public List<Movimentacao> listar() {
        List<Movimentacao> movimentacoes = new ArrayList<>();
        String sql = """
                    SELECT 
                        m.id_movimentacao,
                        m.quantidade_movimentada,
                        m.tipo_movimentacao,
                        m.data,
                        p.id_produto,
                        p.nome AS nome_produto
                    FROM movimentacao m
                    JOIN produto p ON m.id_produto = p.id_produto
                """;

        try (Connection conn = ConexaoDAO.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setId(rs.getInt("id_movimentacao"));
                movimentacao.setQuantidade(rs.getInt("quantidade_movimentada"));
                movimentacao.setTipo(TipoMovimentacao.valueOf(rs.getString("tipo_movimentacao")));
                movimentacao.setData(rs.getTimestamp("data").toLocalDateTime());

                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome_produto"));
                movimentacao.setProduto(produto);

                movimentacoes.add(movimentacao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movimentacoes;
    }


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
