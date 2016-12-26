package com.catamania.crud;

import javax.naming.Context;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.util.Optional;

/*
service qui retourne une connection à la base mySql
*/
public class DBService {

  public Optional<Connection> getConnection() {
    try {
      Context context = new InitialContext();
      DataSource dataSource = (DataSource) context.lookup("java:/MySqlDS");
      Connection connection = dataSource.getConnection();
      return Optional.ofNullable(connection);
    } catch(javax.naming.NamingException | java.sql.SQLException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

}
