package com.spring.henallux.dataAccess.DAO;


import com.spring.henallux.model.TraductionMaterielModel;

import java.util.List;

public interface TraductionMaterielDAO {
    TraductionMaterielModel find(Integer id);

    List<TraductionMaterielModel> findAll();
}
