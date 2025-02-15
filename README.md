# REST API with Spring Boot & MySQL

A simple and basic REST API built using **Spring Boot** and **MySQL**, supporting **CRUD operations** (`Create, Read, Update, Delete`).  

---

## Tech Stack
- **Spring Boot** (Java Backend)
- **MySQL** (Database)
- **Spring Data JPA** (ORM)
- **Rest Assured** (Automated API Testing)
- **Postman** (Manual API Testing)

---

## API runs at: http://localhost:8080

🌐 API Endpoints

- Method	Endpoint	Description
```
GET	/users	Fetch all users
GET	/users/{id}	Fetch a user by ID
POST	/users	Create a new user (name required)
PUT	/users/{id}	Update a user (name required)
DELETE	/users/{id}	Delete a user by ID
```
---

## Run API Tests (Rest Assured)

```
mvn test
```
