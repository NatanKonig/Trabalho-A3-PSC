package com.psc.dao;

import com.psc.model.Categoria;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private List<Categoria> categorias = new ArrayList<>();

    public void adicionar(Categoria categoria) {
        categorias.add(categoria);
        }
    
    public Categoria buscarPorNome(String nome) {
        for (Categoria cat : categorias) {
            if (cat.getnome().equalsIgnoreCase(nome)) {
                return cat;
            
            }
        
        }
        return null;
    }
    
    public boolean remover(String nome) {
        Categoria cat = buscarPorNome(nome);
        if (cat != null) {
            categorias.remove(cat);
            return true;
        }
        return false;
    }

}
