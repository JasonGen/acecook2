package com.spring.henallux.dataAccess.repository;

import com.spring.henallux.dataAccess.Entity.MaterielEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RepositoryMateriel extends JpaRepository<MaterielEntity, Integer>{

}
