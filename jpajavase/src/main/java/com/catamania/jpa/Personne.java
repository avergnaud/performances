package com.catamania.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Persons")
public class Personne implements Serializable {

	@Id
	@Column(name = "ID", unique = true)
	private int id;

	@Column(name = "prenom", nullable = false)
	private String prenom;

	@Column(name = "nom", nullable = false)
	private String nom;

  /* getters and setters > lombok */

	@Override
	public String toString() {
		return id + "\t" + prenom + "\t" + nom;
	}

}
