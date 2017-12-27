package com.spring.henallux.dataAccess.Entity;

import javax.persistence.*;

@Entity
@Table(name = "lignecommande")
public class LigneCommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Idlignecommande")
    private Integer idLigneCommande;

    @Column(name = "Prixreel", columnDefinition = "Decimal(8,2)")
    private Double prixReel;

    @Column(name = "Nombrepieces", nullable = false)
    private Integer nombrePieces;

    @ManyToOne
    @JoinColumn(name = "numerocommande", referencedColumnName = "Numerocommande", nullable = false)
    private AchatEntity achat;

    @ManyToOne
    @JoinColumn(name = "Idmateriel", referencedColumnName = "Idmateriel", nullable = false)
    private MaterielEntity materiel;


    public Integer getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(Integer idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public Double getPrixReel() {
        return prixReel;
    }

    public void setPrixReel(Double prixReel) {
        this.prixReel = prixReel;
    }

    public Integer getNombrePieces() {
        return nombrePieces;
    }

    public void setNombrePieces(Integer nombrePieces) {
        this.nombrePieces = nombrePieces;
    }

    public AchatEntity getAchat() {
        return achat;
    }

    public void setAchat(AchatEntity achat) {
        this.achat = achat;
    }

    public MaterielEntity getMateriel() {
        return materiel;
    }

    public void setMateriel(MaterielEntity materiel) {
        this.materiel = materiel;
    }
}
