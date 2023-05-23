**Todo Application API**
This repository contains the backend code for a Todo Application API. The API allows multiple users to create, update, delete, and manage their todo lists. It provides a simple and intuitive interface for interacting with todo items.

**Features**
Create a new todo item.
Update an existing todo item's name.
Delete a todo item.
Get a list of all todo items.

**Technologies Used**
The Todo Application API is built using the following technologies:

Java: The backend is written in Java
Spring Boot: Spring Boot is used as the framework for building Java-based web applications
Spring Data JPA: Spring Data JPA is used to simplify database operations and interact with the underlying persistence layer.
MySQL: MySQL is used as the database for storing todo items and user information.
Maven: Maven is used as the build automation tool and dependency management system for the project.

**Getting Started**
To get started with the Todo Application API, follow these steps:

Clone the repository: ```git clone git@github.com:tate-minch-bw/Tate-To-Do-App-API.git```
Install the required dependencies using Maven: ```mvn install```
Set up the database:
Install MySQL and create a new database.
Update the database connection settings in the application.properties file.
Start the server: ```mvn run```
The API will now be accessible at http://localhost:8080 (or the port specified in the application.properties file).

API Endpoints
The following API endpoints are available:

GET /user/{userId}: get a user by ID
GET /users: get a list of all users
POST /user: Create a new user
DELETE /user/{userId}: Delete a user by ID
POST /user/{userId}/task: Create a new task for a user
GET /user/{userId}/tasks: Get a list of tasks for a given user
GET /user/{userId}/task/{taskId}: Get a specific task for a specifc user
DELETE /user/{userId}/task/{taskId}: Delete a given task for a given user
PUT /user/{userId}/task/{taskId}: Update a task for a given user
