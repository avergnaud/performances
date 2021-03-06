package com.catamania.jpa;

import javax.inject.Inject;
import java.util.*;
import static java.lang.System.out;
import java.sql.*;
import java.util.*;
import javax.persistence.*;
import javax.transaction.*;
import javax.ejb.*;

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
public Personne ajoutePersonne(Personne personne)
{
        manager.persist(personne);
        return personne;
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

/* supprime une personne
   In JPA, to remove an entity, the entity itself must be managed, meaning that it is present in the persistence context. This means that the calling application should have already loaded or accessed the entity and is now issuing a command to remove it
 */
 @Transactional
 @TransactionAttribute(TransactionAttributeType.REQUIRED)/* inutile */
public void supprimePersonne()
{
        List<Personne> personnes = manager.createQuery("SELECT p FROM Personne p", Personne.class )
                                   .setMaxResults(1)
                                   .getResultList();/* TODO ? SELECT FOR UPDATE ? */

        if(personnes != null && personnes.size() != 0) {
                manager.remove(personnes.get(0));
        }
}

}
