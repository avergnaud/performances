package com.catamania.crud;

import javax.inject.Inject;
import java.util.*;
import static java.lang.System.out;
import java.sql.*;
import java.util.*;

/*
   Service qui effectue les CRUD en base mySql
 */
public class CRUDService {

@Inject
DBService dbService;

String insertStatement = "insert into Persons (prenom,nom) values (?,?)";

String updateStatement = "update Persons set prenom = ?, nom = ? where id = ?";

String deleteStatement = "delete from Persons where id = ?";

/* retourne toutes les personnes */
public List<Personne> getAllPersonnes()
{
        Optional<Connection> oc = dbService.getConnection();
        if(!oc.isPresent()) {
                out.println("getAllPersonnes oc.isEmpty");
                return new ArrayList();
        }
        List<Personne> retour = new ArrayList<>();
        try (Connection connection = oc.get();
            Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select * from Persons"); ) {
                        while(rs.next()) {
                                Personne personne = new Personne(rs.getInt(1),rs.getString(2),rs.getString(3));
                                retour.add(personne);
                        }
                } catch(java.sql.SQLException e) {
                  e.printStackTrace();
                }
                return retour;
}

/* insert une personne en base */
public Personne ajoutePersonne(Personne personne)
{
        Optional<Connection> oc = dbService.getConnection();
        if(!oc.isPresent()) {
                out.println("getAllPersonnes oc.isEmpty");
                return new Personne();
        }
        try (Connection connection = oc.get();
              PreparedStatement ps = connection.prepareStatement(insertStatement,
                                                                Statement.RETURN_GENERATED_KEYS)) {
                        ps.setString(1,personne.getPrenom());
                        ps.setString(2,personne.getNom());
                        int affectedRows = ps.executeUpdate();
                        ResultSet generatedKeys = ps.getGeneratedKeys();
                        if (generatedKeys.next()) {
                                personne.setId(generatedKeys.getInt(1));
                        }
                        generatedKeys.close();
                } catch(java.sql.SQLException e) {
                  e.printStackTrace();
                }
                return personne;
}

/* update une personne */
public Personne metAJourPersonne(Personne personne)
{
        Optional<Connection> oc = dbService.getConnection();
        if(!oc.isPresent()) {
                out.println("metAJourPersonne oc.isEmpty");
                return new Personne();
        }
        try (Connection connection = oc.get();
            PreparedStatement ps = connection.prepareStatement(updateStatement)) {
                        ps.setString(1,personne.getPrenom());
                        ps.setString(2,personne.getNom());
                        ps.setInt(3,personne.getId());
                        int affectedRows = ps.executeUpdate();
                } catch(java.sql.SQLException e) {
                  e.printStackTrace();
                }
                return personne;
}

/* supprime une personne par son id */
public void SupprimePersonne(int id)
{
        Optional<Connection> oc = dbService.getConnection();
        if(!oc.isPresent()) {
                out.println("SupprimePersonne oc.isEmpty");
                return ;
        }
        try (
        Connection connection = oc.get();
        PreparedStatement ps = connection.prepareStatement(deleteStatement)) {
                        ps.setInt(1,id);
                        int affectedRows = ps.executeUpdate();
                } catch(java.sql.SQLException e) {
                  e.printStackTrace();
                }
}

/* supprime une personne au hasard */
public void SupprimePersonne()
{
        Optional<Connection> oc = dbService.getConnection();
        if(!oc.isPresent()) {
                out.println("SupprimePersonne oc.isEmpty");
                return ;
        }
        try (
        Connection connection = oc.get();
        Statement stmt = connection.createStatement();) {
                        int affectedRows = stmt.executeUpdate("DELETE FROM Persons LIMIT 1");
                } catch(java.sql.SQLException e) {
                  e.printStackTrace();
                }
}

}
