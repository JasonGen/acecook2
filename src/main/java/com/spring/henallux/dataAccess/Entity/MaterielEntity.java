package com.spring.henallux.dataAccess.Entity;

import javax.persistence.*;

@Entity
@Table(name = "materiel")
public class MaterielEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Idmateriel")
	private Integer idMateriel;

	@Column(name = "Photo", length = 100)
	private String photo;

	@Column(name = "Prix", columnDefinition = "Decimal(8,2)")
	private Double prix;
	
	@Column(name = "Quantitestock", nullable = false)
	private Integer quantiteStock;

	public Integer getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(Integer idMateriel) {
		this.idMateriel = idMateriel;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(Integer quantiteStock) {
		this.quantiteStock = quantiteStock;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


}
