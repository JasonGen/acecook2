package com.spring.henallux.dataAccess.DAO;

import com.spring.henallux.model.ClientModel;

public interface ClientDAO {
    ClientModel find(Integer id);

    void save(ClientModel clientModel);

    boolean isEmailExist(String email);

    ClientModel existForEmailAndPassword(String email, String password);

}
