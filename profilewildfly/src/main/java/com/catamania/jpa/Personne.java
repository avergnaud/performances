package com.catamania.jpa;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="HbmPersonne")
public class Personne implements Serializable {

	@Id
	@GeneratedValue
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
