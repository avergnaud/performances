package com.catamania.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	// Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("CatJPA");

	public static void main(String[] args) {

		// Create
		create("Toto","Chabo");
		create("LaVoixDe","DerriereLesFagots");

		// Update
		//upate(2, "Bob", "");

		// Delete the Alice from database
		//delete(1);

		// Print all the Personne
		List<Personne> personnes = readAll();
		if (personnes != null) {
			for (Personne p : personnes) {
				System.out.println(p);
			}
		}

		// NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
		ENTITY_MANAGER_FACTORY.close();
	}

	/**
	 * Create a new Personne
	 */
	public static void create(String prenom, String nom) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Create a new Personne
			Personne personne = new Personne();
			personne.setPrenom(prenom);
			personne.setNom(nom);

			// Save the peronne object
			manager.persist(personne);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	/**
	 * Read all the Personne
	 */
	public static List<Personne> readAll() {

		List<Personne> personnes = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get a List of Personne
			personnes = manager.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
		return personnes;
	}

	/**
	 * Delete the existing Personne
	 */
	public static void delete(int id) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get the Personne object
			Personne personne = manager.find(Personne.class, id);

			// Delete the personne
			manager.remove(personne);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	/**
	 * Update the existing Personne.
	 */
	public static void upate(int id, String prenom, String nom) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get the Personne object
			Personne personne = manager.find(Personne.class, id);

			// Change the values
			personne.setPrenom(prenom);
			personne.setNom(nom);

			// Update the personne
			manager.persist(personne);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}
}
