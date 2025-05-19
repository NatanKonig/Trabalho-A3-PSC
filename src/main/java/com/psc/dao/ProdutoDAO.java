package com.psc.dao;

import com.psc.model.Produto;
import java.util.ArrayList;

// Classe que simula o acesso a dados (banco falso usando ArrayList)
public class ProdutoDAO {
    private ArrayList<Produto> lista = new ArrayList<>();

    // Método para inserir um produto na lista
    public void inserir(Produto produto) {
        lista.add(produto);
    }

    // Método para retornar a lista de produtos
    public ArrayList<Produto> listar() {
        return lista;
    }

    // Método para atualizar um produto pelo ID
    public boolean atualizar(int id, Produto novo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.set(i, novo); // substitui o antigo pelo novo
                return true;
            }
        }
        return false; // se não encontrar
    }

    // Método para deletar um produto pelo ID
    public boolean deletar(int id) {
        return lista.removeIf(produto -> produto.getId() == id); // remove se o ID bater
    }
}
