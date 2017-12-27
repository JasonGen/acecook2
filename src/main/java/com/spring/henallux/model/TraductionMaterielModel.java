package com.spring.henallux.model;

import java.io.Serializable;

public class TraductionMaterielModel implements Serializable {
    private Integer idTradMateriel;
    private String descriptionMateriel;
    private String traductionNomMateriel;
    private MaterielModel materielModel;
    private LangueModel langueModel;

    public Integer getIdTradMateriel() {
        return idTradMateriel;
    }

    public void setIdTradMateriel(Integer idTradMateriel) {
        this.idTradMateriel = idTradMateriel;
    }

    public String getDescriptionMateriel() {
        return descriptionMateriel;
    }

    public void setDescriptionMateriel(String descriptionMateriel) {
        this.descriptionMateriel = descriptionMateriel;
    }

    public String getTraductionNomMateriel() {
        return traductionNomMateriel;
    }

    public void setTraductionNomMateriel(String traductionNomMateriel) {
        this.traductionNomMateriel = traductionNomMateriel;
    }

    public MaterielModel getMaterielModel() {
        return materielModel;
    }

    public void setMaterielModel(MaterielModel materielModel) {
        this.materielModel = materielModel;
    }

    public LangueModel getLangueModel() {
        return langueModel;
    }

    public void setLangueModel(LangueModel langueModel) {
        this.langueModel = langueModel;
    }

}
