package com.spring.henallux.model;

import java.io.Serializable;

public class LigneCommandeModel implements Serializable {
    private Integer idLigneCommande;
    private Integer nombrePieces;
    private Double prixReel;
    private AchatModel numeroCommande;
    private MaterielModel materiel;

    public Integer getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(Integer idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public Integer getNombrePieces() {
        return nombrePieces;
    }

    public void setNombrePieces(Integer nombrePieces) {
        this.nombrePieces = nombrePieces;
    }

    public Double getPrixReel() {
        return prixReel;
    }

    public void setPrixReel(Double prixReel) {
        this.prixReel = prixReel;
    }

    public AchatModel getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(AchatModel numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public MaterielModel getMateriel() {
        return materiel;
    }

    public void setMateriel(MaterielModel materiel) {
        this.materiel = materiel;
    }
}
