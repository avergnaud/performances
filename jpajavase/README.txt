
JAVA SE JPA !

mysql> desc Persons;
+--------+--------------+------+-----+---------+----------------+
| Field  | Type         | Null | Key | Default | Extra          |
+--------+--------------+------+-----+---------+----------------+
| ID     | int(11)      | NO   | PRI | NULL    | auto_increment |
| prenom | varchar(255) | YES  |     | NULL    |                |
| nom    | varchar(255) | YES  |     | NULL    |                |
+--------+--------------+------+-----+---------+----------------+


mvn clean install
mvn exec:java
