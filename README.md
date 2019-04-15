# Chat Server API Challenge

## Setup
This application relies on a [MySQL](https://www.mysql.com/) database to store all the information and messages, so you need to install a MySQL server on your local machine.
The project is build using *JDK 8* and *Spring Boot* so be sure of having **JDK 1.8** or greater installed on your local environment.

Once MySQL is installed you need to create the database and run the application:


1. Create the database schema using the DDL file located in ```sql/asapp_challenge-schema.sql```.
2. Change the user and password for MySQL in the properties file, located in ```src/main/resources/application.properties``` (root/root is configured by default).
3. (Optional) You can modify the default server port by changing the property ```server.port``` located in ```src/main/resources/application.properties``` , the default value is 8080.
4. Run the aplication using the script ```startup.sh``` in the project root folder.

