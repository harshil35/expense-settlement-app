# SettleFlow

SettleFlow is a collaborative expense-settlement platform for groups that share expenses.

Users will be able to create groups, add shared expenses, calculate balances,
and receive settlement notifications that show who owes whom.

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- React + TypeScript + Vite
- PostgreSQL
- Apache Kafka
- Maven
- Git and GitHub

## Current Status

Day 1 — Spring Boot backend, versioned health API, and React frontend setup.
Day 2 — PostgreSQL, Flyway migrations, and ExpenseGroup persistence foundation.
Day 3 — Group-member persistence, relationships, and database validation.

## Run the Backend Locally

```bash
cd backend
./mvnw spring-boot:run
```
## Run the Frontend Locally

```bash
cd frontend
npm install
npm run dev
```

## Local Database Setup

SettleFlow uses PostgreSQL for persistent data.

Create a local database named `settleflow` and an application user named
`settleflow_app`. The backend expects the following environment variable in
its IntelliJ run configuration:

```text
DATABASE_PASSWORD=your-local-postgresql-password
```

## Domain Model

- `ExpenseGroup` represents a shared-expense group.
- `GroupMember` represents a participant within one group.
- A group member belongs to exactly one expense group.
- Group-member email addresses are unique within a group.
