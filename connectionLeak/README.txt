
WildFly 10
mvn clean install wildfly:deploy
mvn wildfly:undeploy

http://localhost:8080/connectionLeak/

postman / jmeter


CONNECTION LEAK :
  CRUDService ligne 34

  mysql> SHOW FULL PROCESSLIST;
    +----+------+-----------------+----------+---------+------+----------+-----------------------+
    | Id | User | Host            | db       | Command | Time | State    | Info                  |
    +----+------+-----------------+----------+---------+------+----------+-----------------------+
    |  3 | root | localhost       | NULL     | Query   |    0 | starting | SHOW FULL PROCESSLIST |
    |  4 | root | localhost:33348 | personne | Sleep   |   37 |          | NULL                  |
    |  5 | root | localhost:33350 | personne | Sleep   |    3 |          | NULL                  |
    +----+------+-----------------+----------+---------+------+----------+-----------------------+
  > incrémente à chaque requête

  Après quelques appels, lorsque le pool de connections est épuisé :
    javax.resource.ResourceException: IJ000655: No managed connections available within configured blocking timeout


HOUSEKKEPING
  CRUDService ligne 64

  11:30:58,051 INFO  [org.jboss.as.server] (management-handler-thread - 1) WFLYSRV0010: Deployed "connectionLeak.war" (runtime-name : "connectionLeak.war")
  11:32:50,870 WARN  [org.jboss.jca.adapters.jdbc.WrappedConnection] (default task-2) IJ030042: Closing a result set you left open, please do your own housekeeping for: com.mysql.jdbc.JDBC42ResultSet@65710a3c: java.lang.Throwable: STACKTRACE
  	at org.jboss.jca.adapters.jdbc.WrappedStatement.registerResultSet(WrappedStatement.java:1538)
  	at org.jboss.jca.adapters.jdbc.WrappedStatement.getGeneratedKeys(WrappedStatement.java:1220)
  	at com.catamania.crud.CRUDService.ajoutePersonne(CRUDService.java:61)
  	at com.catamania.PersonneController.ajoute(PersonneController.java:28)
