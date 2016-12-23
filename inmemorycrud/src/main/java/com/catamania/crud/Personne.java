package com.catamania.crud;

import lombok.Data;

@Data
public class Personne {

int id;
String prenom;
String nom;

public Personne() {
        super();
}
public Personne(int i, String prenom,String nom) {
        super();
        this.id = i;
        this.prenom = prenom;
        this.nom=nom;
}
}
