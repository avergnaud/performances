JBoss 5. Cf run.conf
jboss-profiler.jar -> jboss/bin + chmod
jboss-profiler.properties (Add com.catamania.*) -> jboss/bin + chmod
javassist.jar -> Jboss/bin + chmod
jboss-profiler.sar -> jbossas/server/(default)/deploy + chmod

run.conf JAVA_OPTS

mvn compile war:war

requiert someblockingws up
performances/someblockingws>java -jar target/someblockingws-1.0-SNAPSHOT-jar-with-dependencies.jar

start server from bin directory

Toujours pas de profiling jvisualvm avec JBoss 5. Solution :

jboss-profiler-2.0.0.Beta5>/home/ubuntu/dev/jdk1.6.0_45/bin/java -Xmx512m -Djboss-profiler-client.properties=jboss-profiler-client.properties -jar jboss-profiler-client.jar startProfiler

http://localhost:8080/profilejboss5-0.0.1-SNAPSHOT/numberone

jboss-profiler-2.0.0.Beta5>/home/ubuntu/dev/jdk1.6.0_45/bin/java -Xmx512m -Djboss-profiler-client.properties=jboss-profiler-client.properties -jar jboss-profiler-client.jar snapshot

/home/ubuntu/dev/jboss-profiler-2.0.0.Beta5>/home/ubuntu/dev/jdk1.6.0_45/bin/java -Xmx512m -Djboss-profiler-client.properties=jboss-profiler-client.properties -jar jboss-profiler-client.jar stopProfiler

Methods

Count	Ms	% (C)	% (T)	Method
5001	10452,03	100,00	100,00	com.catamania.CompoundService#faster(String)
1	0,02	0,00	0,00	com.catamania.CompoundService#(String, int)
