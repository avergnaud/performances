package com.catamania.jpa;

import javax.inject.Inject;
import java.util.*;
import static java.lang.System.out;
import java.sql.*;
import java.util.*;
import javax.persistence.*;
import javax.transaction.*;

/*
   Uses Container Managed EntityManager
 */
public class CRUDService {

@PersistenceContext(type=PersistenceContextType.TRANSACTION)
private EntityManager manager;

/* retourne toutes les personnes */
public List<Personne> getAllPersonnes()
{
        List<Personne> personnes = manager.createQuery("SELECT p FROM Personne p", Personne.class ).getResultList();
        return personnes;
}

/* insert une personne en base */
@Transactional
public int ajoutePersonne(Personne personne)
{
        manager.persist(personne);
        manager.flush();
        return personne.getId();
}

/* update une personne */
@Transactional
public Personne metAJourPersonne(Personne input)
{
        Personne personne = manager.find(Personne.class, input.getId());
        // Change the values
        personne.setPrenom(input.getPrenom());
        personne.setNom(input.getNom());
        // Update the personne
        manager.persist(personne);
        return personne;
}

/* supprime une personne par son id */
@Transactional
public void supprimePersonne(int id)
{
        Personne personne = manager.find(Personne.class,id);
        if(personne != null) {
          manager.remove(personne);
        }
}

}
