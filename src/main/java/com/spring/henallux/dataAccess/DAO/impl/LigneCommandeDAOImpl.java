package com.spring.henallux.dataAccess.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.henallux.dataAccess.DAO.LigneCommandeDAO;
import com.spring.henallux.dataAccess.repository.RepositoryLigneCommande;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.LigneCommandeModel;
import org.springframework.stereotype.Service;

@Service
public class LigneCommandeDAOImpl implements LigneCommandeDAO{
	
    @Autowired
    private RepositoryLigneCommande repositoryLigneCommande;
    
    @Autowired
    private ProviderConverter providerConverter;
   
	@Override
	public LigneCommandeModel find(Integer id) {
		return providerConverter.ligneCommandeEntityToModel(repositoryLigneCommande.findOne(id));
	}

    @Override
    public void save(LigneCommandeModel ligneCommandeModel) {
        repositoryLigneCommande.save(providerConverter.ligneCommandeModelToEntity(ligneCommandeModel));
    }
}
