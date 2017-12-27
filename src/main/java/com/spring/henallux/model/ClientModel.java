package com.spring.henallux.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.spring.henallux.dataAccess.Entity.AchatEntity;

public class ClientModel implements Serializable {

    private Integer idClient;

    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z]+$")
    @NotBlank
    private String nom;

    @Pattern(regexp = "^[A-Za-z]+$")
    @Size(min = 2, max = 50)
    @NotBlank
    private String prenom;

    private String numTel;

    @Email
    @Size(min = 5, max = 100)
    @NotBlank
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaiss;

    @Min(value = 1000)
    @Max(value = 9999)
    @NotNull
    private Integer codePostal;

    @Pattern(regexp = "^[A-Za-z]+$")
    @Size(min = 5, max = 30)
    @NotBlank
    private String ville;

    @Size(min = 5, max = 30)
    @NotBlank
    private String rue;

    @Size(min = 1, max = 6)
    @NotBlank
    private String numeroRue;

    @Size(min = 2, max = 30)
    @NotBlank
    private String motDePasse;

    private String confirmationMotDePasse;

//	private List<AchatModel> listeAchats;


    public String getConfirmationMotDePasse() {
        return confirmationMotDePasse;
    }

    public void setConfirmationMotDePasse(String confirmationMotDePasse) {
        this.confirmationMotDePasse = confirmationMotDePasse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


}
