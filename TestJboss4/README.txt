Pour JProfiler, dans les VM args du JBoss, ajouter :
-agentpath:/home/ubuntu/jprofiler9/bin/linux-x64/libjprofilerti.so=port=8849 -Xbootclasspath/a:/home/ubuntu/jprofiler9/bin/agent.jar

http://localhost:8080/TestJboss4/

eclipse VM args pour JProfiler :
"-Dprogram.name=JBossTools: JBoss AS 4.2" -server -Djava.awt.headless=true -Xms256m -Xmx512m -XX:MaxPermSize=256m -Djava.net.preferIPv4Stack=true -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.dgc.server.gcInterval=3600000 -agentpath:/home/ubuntu/jprofiler9/bin/linux-x64/libjprofilerti.so=port=8849 -Xbootclasspath/a:/home/ubuntu/jprofiler9/bin/agent.jar "-Djava.endorsed.dirs=/home/ubuntu/dev/jboss-4.2.3.GA/lib/endorsed" -Djava.endorsed.dirs="/home/ubuntu/dev/jboss-4.2.3.GA/lib/endorsed"
