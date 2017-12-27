package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.henallux.dataAccess.Entity.ClientEntity;
import com.spring.henallux.dataAccess.Entity.TraductionMaterielEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RepositoryTraductionMateriel extends JpaRepository<TraductionMaterielEntity, Integer>{

}
