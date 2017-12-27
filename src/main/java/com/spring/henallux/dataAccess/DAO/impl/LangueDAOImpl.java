package com.spring.henallux.dataAccess.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.henallux.dataAccess.DAO.LangueDAO;
import com.spring.henallux.dataAccess.repository.RepositoryLangue;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.AchatModel;
import com.spring.henallux.model.LangueModel;

public class LangueDAOImpl implements LangueDAO{
	
    @Autowired
    private RepositoryLangue repositoryLangue;
    @Autowired
    private ProviderConverter providerConverter;
   
	@Override
	public LangueModel find(Integer id) {
		
		return providerConverter.langueEntityToModel(repositoryLangue.findOne(id));
	}

}
