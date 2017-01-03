
WildFly 10
mvn clean install wildfly:deploy
mvn wildfly:undeploy

http://localhost:8080/jpacrud/

postman / jmeter



Monitoring MySql : mytop --prompt -d personne
mytop.png





[standalone@localhost:9990 /] /subsystem=datasources:read-resource
{
    "outcome" => "success",
    "result" => {
        "data-source" => {
            "ExampleDS" => undefined,
            "MySqlDS" => undefined
        },
        "jdbc-driver" => {
            "h2" => undefined,
            "mysql" => undefined
        },
        "xa-data-source" => undefined
    }
}





/subsystem=datasources/data-source=MySqlDS/statistics=pool:read-resource(include-runtime=true)
