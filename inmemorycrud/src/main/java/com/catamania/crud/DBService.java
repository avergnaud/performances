package com.catamania.crud;

import javax.naming.Context;
import javax.sql.DataSource;
import javax.naming.InitialContext;

public class DBService {

  public boolean testDB() {
    try {
      Context context = new InitialContext();
      DataSource dataSource = (DataSource) context.lookup("java:/MySqlDS");
      return dataSource != null;
    } catch(javax.naming.NamingException e) {
      e.printStackTrace();
      return false;
    }
  }

}
