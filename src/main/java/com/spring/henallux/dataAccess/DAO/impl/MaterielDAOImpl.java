package com.spring.henallux.dataAccess.DAO.impl;

import com.spring.henallux.dataAccess.Entity.MaterielEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.henallux.dataAccess.DAO.MaterielDAO;
import com.spring.henallux.dataAccess.repository.RepositoryMateriel;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.MaterielModel;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MaterielDAOImpl implements MaterielDAO {

    @Autowired
    private RepositoryMateriel repositoryMateriel;

    @Autowired
    private ProviderConverter providerConverter;

    @Override
    public MaterielModel find(Integer id) {
        return providerConverter.materielEntityToModel(repositoryMateriel.findOne(id));
    }

    @Override
    public List<MaterielModel> findAll() {
        return repositoryMateriel.findAll()
                .stream()
                .map(e -> providerConverter.materielEntityToModel(e))
                .collect(toList());
    }

    @Override
    public void updateStock(MaterielEntity entity) {
        repositoryMateriel.saveAndFlush(entity);
    }
}
