# Member Registration System

## Author
Daniel Espinola - daniel.espinola.hym@gmail.com

## Description
This project is a simple Member Registration System built using Spring Boot, which allows users to register members, search for members by email, and retrieve all members.

## Technologies Used
- **Java** 21
- **Spring Boot** 3.2
- **Spring Data JPA**
- **H2 Database** (In-memory)
- **Lombok** for reducing boilerplate code
- **JUnit 5** for testing
- **Postman** for API testing

## Prerequisites
Before running the project, ensure you have the following installed on your machine:
- Java 21
- Maven

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/yourusername/member-registration-system.git
cd member-registration-system
```

### Build the Project
```
mvn clean install
```

### Run the project

### Accessing the H2 Database Console
```
http://localhost:8080/h2-console
```

## API Endpoints
### Add a Member
```
curl --location 'http://localhost:8080/api/members' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"despi",
    "email":"asd@asd.com",
    "phoneNumber":"1234451234"
}'
```
### Retrieve all users ordered by name
```
curl --location 'http://localhost:8080/api/members'
```
### Retrieve user by email
```
curl --location 'http://localhost:8080/api/members/email/{email}'
```