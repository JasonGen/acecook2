package com.spring.henallux.dataAccess.DAO.impl;

import com.spring.henallux.dataAccess.Entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.henallux.dataAccess.DAO.ClientDAO;
import com.spring.henallux.dataAccess.repository.RepositoryClient;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.ClientModel;

@Service
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private RepositoryClient repositoryClient;
    @Autowired
    private ProviderConverter providerConverter;

    @Override
    public ClientModel find(Integer id) {
        return providerConverter.clientEntityToModel(repositoryClient.findOne(id));
    }

    @Override
    public void save(ClientModel clientModel) {
        repositoryClient.save(providerConverter.clientModelToEntity(clientModel));
    }

    @Override
    public boolean isEmailExist(String email) {
        return repositoryClient.isEmailExist(email) == 1 ? true : false;
    }

    @Override
    public ClientModel existForEmailAndPassword(String email, String password) {
        ClientEntity client = repositoryClient.isExistMailPassword(email, password);
        return client == null ? null : providerConverter.clientEntityToModel(client);
    }

}
