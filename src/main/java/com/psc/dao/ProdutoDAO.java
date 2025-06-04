package com.psc.dao;

import com.psc.model.Categoria;
import com.psc.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe responsável pelo acesso e manipulação dos dados de {@link Produto} no banco de dados.
 *
 * <p>Fornece métodos para inserir, listar, atualizar, reajustar preços e deletar produtos</p>
 *
 * @author Machadox18
 * @version 1.0
 */
public class ProdutoDAO {

    /**
     * Insere um novo produto no banco de dados. Após a execução do INSERT, recupera
     * a chave gerada automaticamente e atribui ao objeto {@code p}.
     *
     * @param p objeto {@link Produto} a ser inserido; seus atributos serão persistidos
     *          nos campos: nome, preço unitário, unidade, quantidade em estoque, quantidade mínima,
     *          quantidade máxima e ID de categoria.
     */
    public void inserir(Produto p) {
        String sql = "INSERT INTO produto (nome, preco_unitario, unidade, qtd_estoque, qtd_minima, qtd_maxima, id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Preenche os parâmetros
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPrecoUnitario());
            stmt.setString(3, p.getUnidade());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setInt(5, p.getQuantidadeMinima());
            stmt.setInt(6, p.getQuantidadeMaxima());
            stmt.setInt(7, p.getCategoria().getId());

            // Executa o INSERT
            stmt.executeUpdate();

            // Recupera o ID gerado automaticamente
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                p.setId(idGerado); // atualiza o objeto com o ID do banco
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    /**
     * Recupera todos os produtos cadastrados no banco de dados, juntamente com sua categoria associada.
     *
     * @return uma lista de {@link Produto} contendo todos os produtos encontrados;
     * retorna lista vazia se nenhum registro for encontrado ou ocorrer erro.
     */
    public ArrayList<Produto> listar() {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.nome AS nome_categoria FROM produto p JOIN categoria c ON p.id_categoria = c.id_categoria";

        try (Connection conn = ConexaoDAO.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria cat = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nome_categoria")
                );

                Produto p = new Produto(
                        rs.getInt("id_produto"),
                        rs.getString("nome"),
                        rs.getDouble("preco_unitario"),
                        rs.getString("unidade"),
                        rs.getInt("qtd_estoque"),
                        rs.getInt("qtd_minima"),
                        rs.getInt("qtd_maxima"),
                        cat
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Reajusta o preço unitário de todos os produtos, aumentando ou diminuindo
     * de acordo com o percentual informado.
     *
     * <p>O cálculo é feito como: {@code novo_preco = preco_unitario + (preco_unitario * percentual / 100)}.</p>
     *
     * @param percentual valor percentual para reajustar preços (exemplo: 10 para aumentar 10%, -5 para desconto de 5%)
     * @return {@code true} se o UPDATE for executado com sucesso; {@code false} caso ocorra erro de SQL
     */
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

    /**
     * Atualiza os dados de um produto já existente no banco de dados.
     *
     * <p>A atualização contempla os seguintes campos: nome, preço unitário, unidade,
     * quantidade em estoque, quantidade mínima, quantidade máxima e ID de categoria,
     * com base no {@code id_produto} informado.</p>
     *
     * @param p objeto {@link Produto} contendo os novos valores; seu atributo {@code id}
     *          deve corresponder a um registro existente no banco.
     */
    public void atualizar(Produto p) {
        String sql = "UPDATE produto SET nome=?, preco_unitario=?, unidade=?, qtd_estoque=?, qtd_minima=?, qtd_maxima=?, id_categoria=? WHERE id_produto=?";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPrecoUnitario());
            stmt.setString(3, p.getUnidade());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setInt(5, p.getQuantidadeMinima());
            stmt.setInt(6, p.getQuantidadeMaxima());
            stmt.setInt(7, p.getCategoria().getId());
            stmt.setInt(8, p.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    /**
     * Exclui um produto do banco de dados com base no seu identificador.
     *
     * @param id identificador do produto a ser removido (campo {@code id_produto} na tabela)
     * @return {@code true} se a exclusão for realizada com sucesso; {@code false} caso ocorra erro de SQL
     */
    public boolean deletar(int id) {
        String sql = "DELETE FROM produto WHERE id_produto=?";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
        return false;
    }

}
