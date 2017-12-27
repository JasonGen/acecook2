package com.spring.henallux.dataAccess.util;

import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.Entity.*;
import com.spring.henallux.model.*;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ProviderConverter {

    public ClientModel clientEntityToModel(ClientEntity entity) {
        ClientModel clientModel = new ClientModel();
        clientModel.setIdClient(entity.getIdClient());
        clientModel.setNom(entity.getNom());
        clientModel.setPrenom(entity.getPrenom());
        clientModel.setDateNaiss(entity.getDateNaiss());
        clientModel.setEmail(entity.getEmail());
        clientModel.setNumTel(entity.getNumTel());
        clientModel.setMotDePasse(entity.getMotDePasse());
        clientModel.setNumeroRue(entity.getNumeroRue());
        clientModel.setRue(entity.getRue());
        clientModel.setVille(entity.getVille());
        clientModel.setCodePostal(entity.getCodePostal());

        return clientModel;
    }

    public ClientEntity clientModelToEntity(ClientModel model) {

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setIdClient(model.getIdClient());
        clientEntity.setNom(model.getNom());
        clientEntity.setPrenom(model.getPrenom());
        clientEntity.setDateNaiss(model.getDateNaiss());
        clientEntity.setEmail(model.getEmail());
        clientEntity.setNumTel(model.getNumTel());
        clientEntity.setMotDePasse(model.getMotDePasse());
        clientEntity.setNumeroRue(model.getNumeroRue());
        clientEntity.setRue(model.getRue());
        clientEntity.setVille(model.getVille());
        clientEntity.setCodePostal(model.getCodePostal());
        return clientEntity;
    }

    public AchatEntity achatModelToEntity(AchatModel model) {
        AchatEntity achatEntity = new AchatEntity();
        achatEntity.setDateAchat(model.getDateAchat());
        achatEntity.setClient(clientModelToEntity(model.getClient()));
        achatEntity.setLigneCommandeEntities(model.getLigneCommandeModelList().stream()
                .map(e -> {
                    LigneCommandeEntity entity = ligneCommandeModelToEntity(e);
                    //Pour ne pas que la FK soit null
                    entity.setAchat(achatEntity);
                    return entity;
                })
                .collect(Collectors.toList()));
        return achatEntity;
    }

    public AchatModel achatEntityToModel(AchatEntity entity) {

        AchatModel achatModel = new AchatModel();
        achatModel.setNumeroCommande(entity.getNumCom());
        achatModel.setDateAchat(entity.getDateAchat());
        achatModel.setClient(clientEntityToModel(entity.getClient()));
        achatModel.setLigneCommandeModelList(entity.getLigneCommandeEntities().stream()
                .map(e -> {
                    LigneCommandeModel model = ligneCommandeEntityToModel(e);
                    model.setNumeroCommande(achatModel);
                    return model;
                })
                .collect(Collectors.toList()));
        return achatModel;
    }

    public LangueModel langueEntityToModel(LangueEntity entity) {

        LangueModel langueModel = new LangueModel();
        langueModel.setIdLangue(entity.getIdLangue());
        langueModel.setCodeLangue(entity.getCodeLangue());
        langueModel.setNomLangue(entity.getCodeLangue());
        return langueModel;
    }

    public LangueEntity langueModelToEntity(LangueModel model) {

        LangueEntity langueEntity = new LangueEntity();
        langueEntity.setCodeLangue(model.getCodeLangue());
        langueEntity.setNomLangue(model.getCodeLangue());
        return langueEntity;
    }

    public LigneCommandeModel ligneCommandeEntityToModel(LigneCommandeEntity entity) {

        LigneCommandeModel lcModel = new LigneCommandeModel();
        lcModel.setIdLigneCommande(entity.getIdLigneCommande());
        lcModel.setMateriel(materielEntityToModel(entity.getMateriel()));
        lcModel.setNombrePieces(entity.getNombrePieces());
        lcModel.setNumeroCommande(achatEntityToModel(entity.getAchat()));
        lcModel.setPrixReel(entity.getPrixReel());
        return lcModel;
    }

    public LigneCommandeEntity ligneCommandeModelToEntity(LigneCommandeModel model) {

        LigneCommandeEntity lcEntity = new LigneCommandeEntity();
        lcEntity.setMateriel(materielModelToEntity(model.getMateriel()));
        lcEntity.setNombrePieces(model.getNombrePieces());
        lcEntity.setPrixReel(model.getPrixReel());
        return lcEntity;
    }

    public MaterielModel materielEntityToModel(MaterielEntity e) {

        MaterielModel m = new MaterielModel();
        m.setIdMateriel(e.getIdMateriel());
        m.setPhoto(e.getPhoto());
        m.setPrix(e.getPrix());
        m.setQuantiteStock(e.getQuantiteStock());
        /*
        TODO : Setter les traductions de tout les produits
         */
        return m;
    }

    public MaterielEntity materielModelToEntity(MaterielModel m) {

        MaterielEntity e = new MaterielEntity();
        e.setIdMateriel(m.getIdMateriel());
        e.setPhoto(m.getPhoto());
        e.setPrix(m.getPrix());
        e.setQuantiteStock(m.getQuantiteStock());
        return e;
    }

    public TraductionMaterielModel traductionMaterielEntityToModel(TraductionMaterielEntity e) {

        TraductionMaterielModel m = new TraductionMaterielModel();
        m.setIdTradMateriel(e.getIdTradMat());
        m.setDescriptionMateriel(e.getDescriptionMateriel());
        m.setLangueModel(langueEntityToModel(e.getLangue()));
        m.setMaterielModel(materielEntityToModel(e.getMateriel()));
        m.setTraductionNomMateriel(e.getTraductionNomMateriel());
        return m;
    }

    public TraductionMaterielEntity traductionMaterielModelToEntity(TraductionMaterielModel m) {

        TraductionMaterielEntity e = new TraductionMaterielEntity();
        e.setDescriptionMateriel(m.getDescriptionMateriel());
        e.setLangue(langueModelToEntity(m.getLangueModel()));
        e.setMateriel(materielModelToEntity(m.getMaterielModel()));
        e.setTraductionNomMateriel(m.getTraductionNomMateriel());

        return e;
    }
}
