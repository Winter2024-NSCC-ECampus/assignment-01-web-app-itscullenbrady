# Todo Application

## How to Run

**1. Install XAMPP** 
Download and install XAMPP from https://www.apachefriends.org/.  
**2. Start Services** 
Open XAMPP Control Panel and start the "Apache" and "MySQL" services.  
**3. Create Database** 
Open your web browser and go to http://localhost/phpmyadmin/. Create a new database schema named *todo_db*.  
**4. Configure Database Connection** 
Ensure that the *db-config.properties* file in the *src/main/resources* directory contains the correct database connection details:  
*jdbc.url=jdbc:mysql://localhost:3306/todo_db
jdbc.username=root
jdbc.password=
jdbc.driver=com.mysql.cj.jdbc.Driver*
Run the Project Open the project in IntelliJ IDEA and click the "Run" button.  

## Explanation

This is a web application developed using JSP, JPA, and MySQL. It was created as part of an assignment with the following instructions:  

 1. Develop the web application using JSP + Servlet + JDBC + MySQL.
 2. Choose one of the following scenarios:
 - Todo App
 - User Management App
This project implements the **Todo App** scenario.  

## Project Structure

**src/main/java/com/example/web3012a1/DBConnection.java**: Manages the database connection.
**src/main/webapp/todo.jsp**: The main JSP file for the Todo application.
**src/main/webapp/WEB-INF/web.xml**: Configuration file for the web application.
**pom.xm**l: Maven configuration file.

## Dependencies

The project uses the following dependencies:  

 - **Jakarta Servlet API**: For handling HTTP requests and responses.
 - **JUnit Jupiter API**: For unit testing.
 - **MySQL Connector**: For connecting to the MySQL database.

## Configuration

**web.xml**
Defines the welcome file and display name for the web application.

    <web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">
    <display-name>Todo List</display-name>
    <welcome-file-list>
        <welcome-file>todo</welcome-file>
    </welcome-file-list>
</web-app>

**pom.xml**
Maven configuration file with project dependencies and build settings.

    <web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">
    <display-name>Todo List</display-name>
    <welcome-file-list>
        <welcome-file>todo</welcome-file>
    </welcome-file-list>
</web-app>

## Database Configuration

Ensure that the **db-config.properties** file contains the correct database connection details:

    jdbc.url=jdbc:mysql://localhost:3306/todo_db
    jdbc.username=root
    jdbc.password=
    jdbc.driver=com.mysql.cj.jdbc.Driver

## Running Tests

To run tests, use the following Maven command:

    mvn test




