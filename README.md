# Job Portal Application

## Overview
A Spring Boot-based Job Portal backend that provides RESTful APIs for job listings, company profiles, and reviews. The application leverages **Spring Data JPA**, **Hibernate ORM**, and an **H2 in-memory database** for persistence. Additionally, **Spring Boot Actuator** is included for monitoring and **HikariCP** for efficient connection pooling.

## Features
- **Job Listings**: CRUD operations for job postings.
- **Company Profiles**: Management of company details and related information.
- **Reviews**: Users can add and manage reviews for companies.
- **RESTful API**: Exposes endpoints for interacting with job data.
- **Spring Boot Actuator**: Health and metrics monitoring.
- **H2 Database**: In-memory database for development and testing.
- **HikariCP**: High-performance connection pooling.

## Technologies Used
- **Spring Boot 3.4.3**
- **Spring Web** (RESTful APIs)
- **Spring Data JPA** (ORM and repository management)
- **Hibernate** (Persistence layer)
- **H2 Database** (In-memory development database)
- **HikariCP** (Database connection pooling)
- **Spring Boot Actuator** (Monitoring & metrics)

## Setup & Running
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/jobportal.git
   cd jobportal
   ```
2. Build the project with Maven:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```
4. Access the application:
   - API Base URL: `http://localhost:7070/`
   - H2 Console: `http://localhost:7070/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)

## API Endpoints (Examples)
- `GET /api/jobs` → Fetch all job listings
- `POST /api/jobs` → Add a new job
- `GET /api/companies` → Fetch all companies
- `POST /api/reviews` → Submit a review for a company

## Configuration
Modify `application.properties` for database and server settings:
```properties
server.port=7070
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
management.endpoints.health.show-details=always
```

## License
This project is open-source under the MIT License.

