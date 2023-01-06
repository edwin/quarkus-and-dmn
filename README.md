# About this Repo

A Decision Model and Notation (DMN) application, on top of Quarkus 

How To
------------

Run the app
 ```
 $ mvn quarkus:dev -s settings.xml
 ```

Build by using mvn
 ```
 $ mvn clean package -s settings.xml
 ```

Test using CURL
 ```
 $ curl -X POST 'http://localhost:8080/Validation' -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{ "age": 15, "salary": 100 }'
 
{"result":"you are eligible for 5000","loan_limit":5000,"salary":100,"age":15}
 ```


Libraries
------------
- Java 11
- Quarkus 2.15.2.Final