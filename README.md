# params_saver

### Installation:

0. verify that maven is installed 
```sh 
mvn --version
```
1. pull project
2. checkout to develop branch
3. execute *(in root folder of project)*: 
```sh 
mvn clean 
```
4. execute *(in root folder of project)*: 
```sh 
mvn install 
```
5. **ONLY FOR FIRST RUN**: change property **spring.jpa.hibernate.ddl-auto=validate** to **spring.jpa.hibernate.ddl-auto=create** into project-dir/resources/application.properties
6. execute: 
```sh 
mvn spring-boot:run
```
7. **after first run** change **spring.jpa.hibernate.ddl-auto=create** back to **spring.jpa.hibernate.ddl-auto=validate** otherwise database data will be cleared each time application is started

### Port and urls

Configured port is: 8080

Urls: 

  - save parameters:        [GET] http://[host]:[port]/save?stationName=value1&action=value2
  - get all saved entities: [GET] http://[host]:[port]/save
