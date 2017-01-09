mvn compile war:war

requiert someblockingws up
performances/someblockingws>java -jar target/someblockingws-1.0-SNAPSHOT-jar-with-dependencies.jar

Configuration JBoss 6 :
https://dzone.com/articles/jboss-profiler-20-coo
  jboss-profiler.jar -> jboss/bin
  jboss-profiler.properties (Add packages to be instrumented in includes) -> jboss/bin
  javassist.jar -> Jboss/bin
  jboss-profiler.sar -> jbossas/server/(default)/deploy
  cf run.conf
  cf jboss-profiler.properties
chmod sur tous les fichiers
#attention, boot depuis bin directory nécessaire :
dev/jboss-6.1.0.Final/bin>./run.sh

jboss-profiler-2.0.0.Beta5>/home/ubuntu/dev/jdk1.6.0_45/bin/java -Xmx512m -Djboss-profiler-client.properties=jboss-profiler-client.properties -jar jboss-profiler-client.jar startProfiler

http://localhost:8080/profilejboss6-0.0.1-SNAPSHOT/numberone

jboss-profiler-2.0.0.Beta5>/home/ubuntu/dev/jdk1.6.0_45/bin/java -Xmx512m -Djboss-profiler-client.properties=jboss-profiler-client.properties -jar jboss-profiler-client.jar snapshot

/home/ubuntu/dev/jboss-profiler-2.0.0.Beta5>/home/ubuntu/dev/jdk1.6.0_45/bin/java -Xmx512m -Djboss-profiler-client.properties=jboss-profiler-client.properties -jar jboss-profiler-client.jar stopProfiler

jboss-profiler-snapshot
Methods
Count	Ms	     Avg	  %	    Method
5000	6670,58	 1,33	  99,19	com.catamania.CompoundService#faster(String)
1	    54,30	   54,30	0,81	com.catamania.NumberOne#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)

En revanche, hors de JBoss, le profiling de jvisualvm fonctionne :
cf someblockingws-jvisualvm.png
