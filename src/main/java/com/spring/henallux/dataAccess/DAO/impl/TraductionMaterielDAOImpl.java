package com.spring.henallux.dataAccess.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.henallux.dataAccess.DAO.TraductionMaterielDAO;
import com.spring.henallux.dataAccess.repository.RepositoryTraductionMateriel;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.TraductionMaterielModel;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TraductionMaterielDAOImpl implements TraductionMaterielDAO{

    @Autowired
    private RepositoryTraductionMateriel repositoryTraductionMateriel;
    
    @Autowired
    private ProviderConverter providerConverter;
   
	@Override
	public TraductionMaterielModel find(Integer id) {
		return providerConverter.traductionMaterielEntityToModel(repositoryTraductionMateriel.findOne(id));
	}

    @Override
    public List<TraductionMaterielModel> findAll() {
        return repositoryTraductionMateriel.findAll()
                .stream()
                .map(e -> providerConverter.traductionMaterielEntityToModel(e))
                .collect(toList());
    }
}
