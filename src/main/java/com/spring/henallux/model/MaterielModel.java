package com.spring.henallux.model;


import java.io.Serializable;
import java.util.List;

public class MaterielModel implements Serializable {
    private Integer idMateriel;
    private String photo;
    private Double prix;
    private Integer quantiteStock;
    private List<TraductionMaterielModel> listTradModel;


    public Integer getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(Integer idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(Integer quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public List<TraductionMaterielModel> getListTradModel() {
        return listTradModel;
    }

    public void setListTradModel(List<TraductionMaterielModel> listTradModel) {
        this.listTradModel = listTradModel;
    }
}
