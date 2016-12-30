
WildFly 10
mvn clean install wildfly:deploy
mvn wildfly:undeploy

http://localhost:8080/mysqlcrud/

postman / jmeter

ParallelGC : standalone.conf.sh
 -XX:+UseParallelGC -XX:+UseParallelOldGC

CMS GC : standalone.conf.sh
-XX:+UseConcMarkSweepGC -XX:+UseParNewGC
> Mais consommation CPU supérieure ! (on passe de 20% à 30%)



Monitoring MySql : mytop --prompt -d personne
mytop.png
analyse : http://mysql.wingtiplabs.com/documentation/top2qykq/real-time-performance-info-with-mytop


.
