# Online Test Exam Maker

## Tools and Technologies:

*   JDK 1.8
*   MySQL
*   Apache Tomcat 8
*   Apache Maven 4.0.0
*   Eclipse IDE
*   Spring 4.3.13.RELEASE
*   Hibernate 4.3.11.Final

## Config MySQL:
The properties to connect to the local MySQL environmnet are defined in the pom.xml file.
```
<db.url>jdbc:mysql://localhost:3306</db.url>
<db.name>onlinetestexammaker</db.name>
<db.username>root</db.username>
<db.password>password</db.password>
```
First you need to make sure that the schema exists and them to generate the tables you need to run the following command:
> mvn liquibase:update