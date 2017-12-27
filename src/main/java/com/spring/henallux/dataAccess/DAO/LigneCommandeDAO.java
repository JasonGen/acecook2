package com.spring.henallux.dataAccess.DAO;

import com.spring.henallux.model.LigneCommandeModel;

public interface LigneCommandeDAO {
    LigneCommandeModel find(Integer id);

    void save(LigneCommandeModel ligneCommandeModel);
}
