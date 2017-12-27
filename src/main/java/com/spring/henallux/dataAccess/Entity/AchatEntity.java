package com.spring.henallux.dataAccess.Entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "achat")
public class AchatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Numerocommande")
    private Integer numCom;

    @Column(name = "Dateachat", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    @ManyToOne
    @JoinColumn(name = "IdClient", referencedColumnName = "IdClient")
    private ClientEntity client;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "achat")
    private Collection<LigneCommandeEntity> ligneCommandeEntities;

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Integer getNumCom() {
        return numCom;
    }

    public void setNumCom(Integer numCom) {
        this.numCom = numCom;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Collection<LigneCommandeEntity> getLigneCommandeEntities() {
        return ligneCommandeEntities;
    }

    public void setLigneCommandeEntities(Collection<LigneCommandeEntity> ligneCommandeEntities) {
        this.ligneCommandeEntities = ligneCommandeEntities;
    }
}
