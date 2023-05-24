# **To Do Application API**<br>
This repository contains the backend code for a Todo Application API. The API allows multiple users to create, update, delete, and manage their todo lists. It provides a simple and intuitive interface for interacting with todo items.

## **Features**<br>
Create a new todo item.
Update an existing todo item's name.
Delete a todo item.
Get a list of all todo items.

## **Technologies Used**<br>
The Todo Application API is built using the following technologies:<br>

Java: The backend is written in Java<br>
Spring Boot: Spring Boot is used as the framework for building Java-based web applications<br>
Spring Data JPA: Spring Data JPA is used to simplify database operations and interact with the underlying persistence layer.<br>
MySQL: MySQL is used as the database for storing todo items and user information.<br>
Maven: Maven is used as the build automation tool and dependency management system for the project.<br>

## **Getting Started**<br>
To get started with the Todo Application API, follow these steps:<br>

Clone the repository: ```git clone git@github.com:tate-minch-bw/Tate-To-Do-App-API.git```<br>
Install the required dependencies using Maven: ```mvn install```<br>
Set up the database:<br>
Install MySQL and ensure ```spring.jpa.hibernate.ddl-auto=create``` is present in application.propetries file.<br>
Update the database connection settings in the application.properties file.<br>
Start the server: ```mvn run```<br>
The API will now be accessible at http://localhost:8080 (or the port specified in the application.properties file).<br>

## **API Endpoints**<br>
The following API endpoints are available:<br>

GET /user/{userId}: get a user by ID<br>
GET /users: get a list of all users<br>
POST /user: Create a new user<br>
DELETE /user/{userId}: Delete a user by ID<br>
POST /user/{userId}/task: Create a new task for a user<br>
GET /user/{userId}/tasks: Get a list of tasks for a given user<br>
GET /user/{userId}/task/{taskId}: Get a specific task for a specifc user<br>
DELETE /user/{userId}/task/{taskId}: Delete a given task for a given user<br>
PUT /user/{userId}/task/{taskId}: Update a task for a given user<br>
