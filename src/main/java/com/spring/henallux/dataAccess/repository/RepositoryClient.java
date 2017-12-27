package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.StringBuilder;

import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.Entity.ClientEntity;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RepositoryClient extends JpaRepository<ClientEntity, Integer> {

    String IS_EMAIL_EXIST = "select count(*) from ClientEntity client " +
            "where client.email = :email";

    @Query(IS_EMAIL_EXIST)
    Integer isEmailExist(@Param("email") String email);

    String IS_EXIST_MAIL_PASSWORD = "select client from ClientEntity client " +
            "where client.email = :email and client.motDePasse = :motDePasse";

    @Query(IS_EXIST_MAIL_PASSWORD)
    ClientEntity isExistMailPassword(@Param("email") String email, @Param("motDePasse") String motDePasse);


}
