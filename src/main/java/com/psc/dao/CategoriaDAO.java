package com.psc.dao;

import com.psc.model.Categoria;
import com.psc.model.EmbalagemProduto;
import com.psc.model.TamanhoProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso e manipulação dos dados da entidade {@link Categoria}
 * no banco de dados. Implementa as operações de inserção, listagem, atualização e exclusão.
 *
 * <p>Utiliza a classe {@code ConexaoDAO} para obter conexões com o banco de dados.</p>
 *
 * <p>Esta classe segue o padrão DAO (Data Access Object).</p>
 *
 * @author AguiarFabricio
 */
public class CategoriaDAO {

    /**
     * Insere uma nova categoria no banco de dados.
     *
     * @param categoria A categoria a ser inserida.
     */
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

    /**
     * Recupera todas as categorias cadastradas no banco de dados.
     *
     * @return Uma lista com todas as categorias encontradas.
     */
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

    /**
     * Atualiza uma categoria existente no banco de dados.
     *
     * @param categoriaAtualizada A categoria com os novos dados a serem atualizados.
     * @return {@code true} se a atualização foi realizada com sucesso, {@code false} caso contrário.
     */
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

    /**
     * Remove uma categoria do banco de dados com base no seu ID.
     *
     * @param id O ID da categoria a ser removida.
     * @return {@code true} se a exclusão foi realizada com sucesso, {@code false} caso contrário.
     */
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
