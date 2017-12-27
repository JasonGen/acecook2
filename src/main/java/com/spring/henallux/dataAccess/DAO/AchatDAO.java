package com.spring.henallux.dataAccess.DAO;

import com.spring.henallux.dataAccess.Entity.AchatEntity;
import com.spring.henallux.model.AchatModel;

public interface AchatDAO {
    AchatModel find(Integer id);

    void save(AchatModel achatModel);

}
