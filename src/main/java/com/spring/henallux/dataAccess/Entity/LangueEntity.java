package com.spring.henallux.dataAccess.Entity;

import javax.persistence.*;

@Entity
@Table(name = "langue")
public class LangueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Idlangue")
    private Integer idLangue;

    @Column(name = "Codelangue", length = 6, nullable = false)
    private String codeLangue;

    @Column(name = "Nomlangue", length = 30, nullable = false)
    private String nomLangue;

    public Integer getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(Integer idLangue) {
        this.idLangue = idLangue;
    }

    public String getCodeLangue() {
        return codeLangue;
    }

    public void setCodeLangue(String codeLangue) {
        this.codeLangue = codeLangue;
    }

    public String getNomLangue() {
        return nomLangue;
    }

    public void setNomLangue(String nomLangue) {
        this.nomLangue = nomLangue;
    }


}
