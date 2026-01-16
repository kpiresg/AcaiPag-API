# AcaiPag-API

[![Status](https://img.shields.io/badge/status-under%20development-orange)](https://github.com/kpiresg/AcaiPag-API)
[![Java](https://img.shields.io/badge/java-17-blue)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/spring--boot-4.0.1-brightgreen)](https://spring.io/projects/spring-boot)

A microservice-based payment API designed for game economy integration. This project focuses on managing accounts and executing secure transactions between players.

## Features (In Progress)

- **Account Management**: Create, read, update, and delete (CRUD) player accounts.
- **Transaction System**: Real-time balance transfers between accounts with validation.
- **Balance Integrity**: Ensuring sufficient funds and transactional atomicity using `@Transactional`.
- **Validation**: Data integrity enforced via `Jakarta Validation`.
- **In-Memory Database**: Fast development and testing with H2 Database.

## Tech Stack

- **Java 17**
- **Spring Boot 4** (Web MVC, Data JPA)
- **Lombok** (Boilerplate reduction)
- **H2 Database** (Development database)
- **Maven** (Dependency management)

## API Endpoints

### Accounts (`/conta`)
- `POST /add` - Register a new account.
- `GET /get/{id}` - Fetch account details by ID.
- `GET /getAll` - List all registered accounts.
- `PATCH /updateSaldo/{id}` - Update account balance.
- `DELETE /delete/{id}` - Remove an account.

### Transactions (`/transacao`)
- `POST /realizarTransacao/{idOrigem}/{idDestino}` - Transfer funds between players.

## How to run

1. Clone the repository:
   ```bash
   git clone [https://github.com/kpiresg/AcaiPag-API.git](https://github.com/SEU-USUARIO/AcaiPag-API.git)
  
2. Install dependencies:
    ```bash
    mvn install
   
3. Run the application:
    ```bash
    mvn spring-boot:run
    
4. Access H2 Console (for debugging): http://localhost:8080/h2-console
