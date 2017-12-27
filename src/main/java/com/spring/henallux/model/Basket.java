package com.spring.henallux.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Basket implements Serializable {

    private Map<Integer, LigneCommandeModel> products = new HashMap<>();

    public Map<Integer, LigneCommandeModel> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, LigneCommandeModel> products) {
        this.products = products;
    }

    public Integer getNumberArticles()
    {
        Integer somme = 0;
        for(LigneCommandeModel lc:products.values())
        {
            somme += lc.getNombrePieces();
        }
        return somme;
    }

    public Double prixTotalAchats()
    {
        Double total = 0.00;
        for(LigneCommandeModel lc:products.values())
        {
            total += (lc.getNombrePieces() * lc.getPrixReel());
        }
        return total;
    }
}
