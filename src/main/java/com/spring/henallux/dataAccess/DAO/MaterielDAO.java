package com.spring.henallux.dataAccess.DAO;

import com.spring.henallux.dataAccess.Entity.MaterielEntity;
import com.spring.henallux.model.MaterielModel;

import java.util.List;

public interface MaterielDAO {
    MaterielModel find(Integer id);

    List<MaterielModel> findAll();

    void updateStock(MaterielEntity entity);
}
