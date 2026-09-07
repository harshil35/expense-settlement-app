````md
# SettleFlow

SettleFlow is a collaborative expense-settlement platform for groups that share expenses.

Users can create groups, add shared expenses, calculate balances, and receive
settlement notifications that show who owes whom.

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- React, TypeScript, and Vite
- PostgreSQL
- Flyway
- Apache Kafka
- Maven
- Git and GitHub

## Current Status

Day 4 — REST API for creating and listing expense groups, with request
validation and consistent error responses.

## Run the Backend Locally

```bash
cd backend
./mvnw spring-boot:run
````

Health check:

```text
GET http://localhost:8080/api/v1/health
```

## Run the Frontend Locally

```bash
cd frontend
npm install
npm run dev
```

The frontend runs at `http://localhost:5173`.

## Local Database Setup

SettleFlow uses PostgreSQL for persistent data.

Create a local database named `settleflow` and an application user named
`settleflow_app`. Add this environment variable to the IntelliJ run
configuration:

```text
DATABASE_PASSWORD=your-local-postgresql-password
```

Database schema changes are managed by Flyway migrations in:

```text
backend/src/main/resources/db/migration
```

Hibernate validates the schema but does not modify it.

## Domain Model

* `ExpenseGroup` represents a shared-expense group.
* `GroupMember` represents a participant within one group.
* A group member belongs to exactly one expense group.
* Group-member email addresses are unique within a group.

## Expense Group API

### Create a group

```text
POST /api/v1/groups
```

Request body:

```json
{
  "name": "Goa Trip"
}
```

Returns `201 Created`.

### List groups

```text
GET /api/v1/groups
```

Returns `200 OK`.

```