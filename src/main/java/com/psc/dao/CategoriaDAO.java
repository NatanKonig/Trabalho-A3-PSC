package com.psc.dao; // Define o pacote onde essa classe está localizada (Data Access Object - DAO).

import com.psc.model.Categoria; // Importa a classe Categoria para poder usá-la aqui.

import java.util.ArrayList; // Importa a classe ArrayList da biblioteca Java.
import java.util.List;      // Importa a interface List.

public class CategoriaDAO { // Define a classe pública 'CategoriaDAO', responsável por gerenciar objetos Categoria.

    // Lista privada que armazena objetos do tipo Categoria em memória.
    private List<Categoria> categorias = new ArrayList<>();

    // Método público que adiciona uma nova categoria à lista.
    public void adicionar(Categoria categoria) {
        categorias.add(categoria); // Insere o objeto categoria na lista.
    }

    public List<Categoria> listar() {
        return categorias;
    }

    // Método público que busca uma categoria pelo nome (ignora maiúsculas/minúsculas).
    public Categoria buscarPorNome(String nome) {
        for (Categoria cat : categorias) { // Percorre todas as categorias da lista.
            if (cat.getNome().equalsIgnoreCase(nome)) { // Compara os nomes (sem considerar maiúsculas/minúsculas).
                return cat; // Retorna a categoria encontrada.
            }
        }
        return null; // Retorna null se nenhuma categoria com esse nome for encontrada.
    }

    // Método público que remove uma categoria da lista com base no nome.
    public boolean remover(String nome) {
        Categoria cat = buscarPorNome(nome); // Busca a categoria com o nome informado.
        if (cat != null) { // Se encontrar a categoria...
            categorias.remove(cat); // ... remove ela da lista.
            return true; // Indica que a remoção foi feita com sucesso.
        }
        return false; // Se não encontrou, retorna falso.
    }

    public int maiorID() {
        int maiorID = 0;
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId() > maiorID) {
                maiorID = categorias.get(i).getId();
            }
        }
        return maiorID;
    }

    public boolean atualizar(Categoria categoriaAtualizada) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId() == categoriaAtualizada.getId()) {
                categorias.set(i, categoriaAtualizada);
                return true;
            }
        }
        return false;
    }

}
