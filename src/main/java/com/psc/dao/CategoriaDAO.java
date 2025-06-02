package com.psc.dao; // Define o pacote onde essa classe está localizada (Data Access Object - DAO).

import com.psc.model.Categoria; // Importa a classe Categoria para poder usá-la aqui.
import com.psc.model.EmbalagemProduto;
import com.psc.model.TamanhoProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;      // Importa a interface List.

public class CategoriaDAO { // Define a classe pública 'CategoriaDAO', responsável por gerenciar objetos Categoria.

    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getTamanho().name());
            stmt.setString(3, categoria.getEmbalagem().name());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection conn = ConexaoDAO.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                categoria.setTamanho(TamanhoProduto.valueOf(rs.getString("tamanho")));
                categoria.setEmbalagem(EmbalagemProduto.valueOf(rs.getString("embalagem")));

                categorias.add(categoria);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }

    public boolean atualizar(Categoria categoriaAtualizada) {
        String sql = "UPDATE categoria SET nome = ?, tamanho = ?, embalagem = ? WHERE id_categoria = ?";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoriaAtualizada.getNome());
            stmt.setString(2, categoriaAtualizada.getTamanho().name());
            stmt.setString(3, categoriaAtualizada.getEmbalagem().name());
            stmt.setInt(4, categoriaAtualizada.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
