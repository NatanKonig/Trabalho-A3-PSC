package dao;

import model.Produto;

import java.util.ArrayList;

// Classe que simula o acesso a dados (banco falso usando ArrayList)
public class ProdutoDAO {

    private ArrayList<Produto> lista = new ArrayList<Produto>();

    // Método para inserir um produto na lista
    public void inserir(Produto produto) {
        lista.add(produto);
    }

    // Método para retornar a lista de produtos
    public ArrayList<Produto> listar() {
        return lista;
    }

    // Método para atualizar um produto pelo ID
    public boolean atualizarId(int id, Produto novo){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.set(i, novo);
                return true;
            }
        }
        return false; // se não encontrar
    }

    // Método para deletar um produto pelo ID
    public boolean deletarId(int id) {
        return lista.removeIf(produto -> produto.getId() == id);
    }
}
