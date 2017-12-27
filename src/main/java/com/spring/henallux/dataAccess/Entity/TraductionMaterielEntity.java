package com.spring.henallux.dataAccess.Entity;

import javax.persistence.*;

@Entity
@Table(name = "traductionmateriel")
public class TraductionMaterielEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Idtradmat")
    private Integer idTradMat;

    @Column(name = "Descriptionmateriel", length = 150)
    private String descriptionMateriel;

    @Column(name = "Traductionnommateriel", length = 30)
    private String traductionNomMateriel;

    @ManyToOne
    @JoinColumn(name = "Idlangue", referencedColumnName = "Idlangue")
    private LangueEntity langue;

    @ManyToOne
    @JoinColumn(name = "Idmateriel", referencedColumnName = "Idmateriel")
    private MaterielEntity materiel;

    public Integer getIdTradMat() {
        return idTradMat;
    }

    public void setIdTradMat(Integer idTradMat) {
        this.idTradMat = idTradMat;
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

    public LangueEntity getLangue() {
        return langue;
    }

    public void setLangue(LangueEntity langue) {
        this.langue = langue;
    }

    public MaterielEntity getMateriel() {
        return materiel;
    }

    public void setMateriel(MaterielEntity materiel) {
        this.materiel = materiel;
    }

}
