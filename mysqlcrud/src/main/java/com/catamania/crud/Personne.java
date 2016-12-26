package com.catamania.crud;

import lombok.Data;

/*
bean Personne. manque un champ id
*/
@Data
public class Personne {

Integer id;
String prenom;
String nom;

public Personne() {
        super();
}
public Personne(Integer id, String prenom,String nom) {
        super();
        this.id = id;
        this.prenom = prenom;
        this.nom=nom;
}
}
