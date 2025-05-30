package com.psc.dao;

import com.psc.model.Categoria;
import com.psc.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {

    // CREATE
    public void inserir(Produto p) {
        String sql = "INSERT INTO produto (nome, preco_unitario, unidade, quantidade_estoque, quantidade_minima, quantidade_maxima, categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Preenche os parâmetros
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPrecoUnitario());
            stmt.setString(3, p.getUnidade());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setInt(5, p.getQuantidadeMinima());
            stmt.setInt(6, p.getQuantidadeMaxima());
            stmt.setString(7, p.getCategoria());

            // Executa o INSERT
            stmt.executeUpdate();

            // Recupera o ID gerado automaticamente
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                p.setId(idGerado); // atualiza o objeto com o ID do banco
            }

            System.out.println("Produto inserido com sucesso. ID: " + p.getId());

        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    // READ
    public ArrayList<Produto> listar() {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try (Connection conn = ConexaoDAO.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco_unitario"),
                        rs.getString("unidade"),
                        rs.getInt("quantidade_estoque"),
                        rs.getInt("quantidade_minima"),
                        rs.getInt("quantidade_maxima"),
                        rs.getString("categoria")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    public ArrayList<Produto> buscarPorNome(String nome) {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco_unitario"),
                        rs.getString("unidade"),
                        rs.getInt("quantidade_estoque"),
                        rs.getInt("quantidade_minima"),
                        rs.getInt("quantidade_maxima"),
                        rs.getString("categoria")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar por nome: " + e.getMessage());
        }

        return lista;
    }

    public boolean reajustarPrecos(double percentual) {
        String sql = "UPDATE produto SET preco_unitario = preco_unitario + (preco_unitario * ? / 100)";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, percentual);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao reajustar preços: " + e.getMessage());
            return false;
        }
    }

    // UPDATE
    public void atualizar(Produto p) {
        String sql = "UPDATE produto SET nome=?, preco_unitario=?, unidade=?, quantidade_estoque=?, quantidade_minima=?, quantidade_maxima=?, categoria=? WHERE id=?";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPrecoUnitario());
            stmt.setString(3, p.getUnidade());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setInt(5, p.getQuantidadeMinima());
            stmt.setInt(6, p.getQuantidadeMaxima());
            stmt.setString(7, p.getCategoria());
            stmt.setInt(8, p.getId());

            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    // DELETE
    public boolean deletar(int id) {
        String sql = "DELETE FROM produto WHERE id=?";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produto deletado com sucesso!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
        return false;
    }

}
