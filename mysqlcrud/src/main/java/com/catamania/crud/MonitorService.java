package com.catamania.crud;

import javax.inject.Inject;
import java.util.*;
import static java.lang.System.out;
import java.sql.*;
import java.util.*;

/*
   Service qui effectue les CRUD en base mySql
 */
public class MonitorService {

@Inject
DBService dbService;

/* retourne toutes les personnes */
public int getCount()
{
        Optional<Connection> oc = dbService.getConnection();
        if(!oc.isPresent()) {
                out.println("getCount oc.isEmpty");
                return 0;
        }
        int retour = 0;
        try (Connection connection = oc.get();
            Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select count(*) from Persons"); ) {
                        if(rs.next()) {
                                retour = rs.getInt(1);
                        }
                } catch(java.sql.SQLException e) {
                  e.printStackTrace();
                }
                return retour;
}

}
