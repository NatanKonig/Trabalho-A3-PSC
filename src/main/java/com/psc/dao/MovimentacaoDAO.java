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
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso e manipulação dos dados de movimentações de estoque no banco de dados.
 *
 * <p>Essa classe fornece métodos para listar todas as movimentações, inserir novas movimentações e
 * atualizar o estoque de produtos conforme as movimentações realizadas.</p>
 *
 * @author EvelynYs2
 * @version 1.0
 */
public class MovimentacaoDAO {

    /**
     * Recupera todas as movimentações de estoque registradas no banco de dados.
     * Cada movimentação inclui dados do produto relacionado.
     *
     * @return uma lista com todas as movimentações encontradas no banco
     */
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


    /**
     * Realiza uma movimentação no estoque e registra essa movimentação no banco.
     * Atualiza o estoque do produto de acordo com o tipo da movimentação (ENTRADA ou SAIDA).
     *
     * @param movimentacao objeto contendo os dados da movimentação a ser realizada
     * @return {@code true} se a movimentação e atualização de estoque foram realizadas com sucesso; {@code false} caso contrário
     */
    public boolean movimentarEstoque(Movimentacao movimentacao) {
        boolean estoqueAtualizado = atualizarEstoque(movimentacao.getProduto(), movimentacao.getQuantidade(), movimentacao.getTipo());

        if (!estoqueAtualizado) {
            System.out.println("Erro ao atualizar o estoque.");
            return false;
        }

        return inserir(movimentacao);
    }

    /**
     * Atualiza a quantidade de estoque do produto no banco de dados, incrementando ou decrementando conforme o tipo da movimentação.
     *
     * @param produto o produto cujo estoque será atualizado
     * @param quantidade a quantidade a ser adicionada ou subtraída do estoque
     * @param tipo o tipo da movimentação: ENTRADA para adicionar, SAIDA para subtrair
     * @return {@code true} se o estoque foi atualizado com sucesso; {@code false} caso contrário
     */
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

    /**
     * Insere um registro de movimentação no banco de dados.
     *
     * @param movimentacao objeto contendo os dados da movimentação a ser inserida
     * @return {@code true} se a inserção foi realizada com sucesso; {@code false} caso contrário
     */
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
