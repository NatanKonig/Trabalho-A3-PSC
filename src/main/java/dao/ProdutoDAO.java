package dao;

import model.Produto;

import java.util.ArrayList;

public class ProdutoDAO {
    private ArrayList<Produto> lista = new ArrayList<Produto>();

    public void inserir(Produto produto) {
        lista.add(produto);
    }

    public ArrayList<Produto> listar() {
        return lista;
    }
}
