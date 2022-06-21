# Angular-SpringBoot-Mybatis

### This is a 3-tier Web Application. 

1. The Front Ent is built using ANGULAR framework
2. The Service layer is built using SpringBoot and its intrinsic rest controller
3. The Persistence Framework is with MyBatis

###### Please refer the to the DB Scripts. For demostration sake, I ahve used the MySQL and its configuration is package as part of the persistence layer project. This can be modified as per the flavour of the Database we would choose.

JUnits are available in the persistence project to Verify the DB Interfacing.
The project is Deploy-able Server: Tomcat Version 9 or less.

## For Angular Project [PersonUI]

`npm install`

To check if the local version works fine use `ng serve` and you can verify it locally.

To build the final artifact, use `ng build --aot` and package the content inside the dist folder and deploy into an static HTTP server's serving location. You can also deploy to TOMCAT, Please follow the below steps:

1. Move the dist directory content(along with the directory - front-end/*) into the ROOT directory inside the tomcat’s webapp
2. In the index.html, Change the `<base href="\">` to `<base href=".">`
3. Start the Tomcat Server, you should be able to access static content using: http://localhost:8080/front-end

If you want a customised name instead of front-end, please make changes to the package.json and try.

## For MyBatis Project. [PersonDetails]

Execute the "PersonQueries.sql" file in a MySQL database. After the above procedure, run `mvn clean install`. You will see the jar file built in the target directory.

## For SpringBoot Project. [Person]

Use `mvn clean install` - This will generate the project as deployable WAR. If you need to check the project with the help of the embedded tomcat, make changes aptly to the code and execute `mvn spring-boot:run`.  Move the WAR file to the tomcat's webapps directory and start the tomcat server. You should be able to access the rest url using the below URLs:

http://localhost:8080/person/saveperson - POST Method (To create the Person Details)

Payload be like - `{
  "personFirstName": "Therese Benancia",
  "personLastName": "Marcelin",
  "personPhoneNumber": 9876458773,
  "address": "Chennai"
}`

http://localhost:8080/person/findperson?personId=XXX - GET method (To retrieve the Person Details - XXX is a person ID)

http://localhost:8080/person//removeperson/XXX - DELETE method (To remove the Person Details - XXX is a person ID)
