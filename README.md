# TradeCore – Multi-Asset Centralized Exchange

TradeCore is a production-inspired centralized exchange built from scratch using Java and Spring Boot. The goal of the project is to simulate how modern exchanges process orders, match buyers and sellers, maintain account balances, and provide real-time market data.

Rather than focusing on cryptocurrency trading itself, this project focuses on the engineering challenges behind an exchange, including low-latency order matching, transactional consistency, event-driven architecture, and scalable backend design.

---

## Features

### Account Management

* Create and manage user accounts
* Email validation and uniqueness
* Account lifecycle management
* Authentication and authorization (future)

### Wallets

* Multi-asset wallets
* Available and reserved balances
* Deposits and withdrawals
* Internal transfers

### Trading

* Market orders
* Limit orders
* Order cancellation
* Partial order fills
* Price-time priority matching

### Matching Engine

* Deterministic matching
* In-memory order books
* Per-symbol matching engine
* Replay support
* Trade generation

### Ledger

* Double-entry accounting
* Settlement processing
* Transaction history
* Balance reconciliation

### Market Data

* Live order book
* Recent trades
* Last traded price
* WebSocket updates

### Infrastructure

* PostgreSQL persistence
* Redis caching
* Kafka event streaming
* Dockerized deployment
* Observability with OpenTelemetry
* Metrics with Prometheus and Grafana

---

# High-Level Architecture

```text
                   Client
                      │
          REST API / WebSocket
                      │
              Spring Boot Backend
                      │
      ┌───────────────┼────────────────┐
      │               │                │
      ▼               ▼                ▼
 Account Service   Order Service   Market Service
      │               │                │
      └───────────────┼────────────────┘
                      ▼
              Matching Engine
                      │
         ┌────────────┴─────────────┐
         ▼                          ▼
      Trade Engine              Order Book
         │                          │
         └────────────┬─────────────┘
                      ▼
                   Ledger
                      │
               PostgreSQL
                      │
        Kafka / Redis / WebSockets
```

---

# Technology Stack

## Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Validation
* Spring Transactions

## Database

* PostgreSQL
* Flyway

## Messaging

* Apache Kafka (planned)

## Cache

* Redis (planned)

## Frontend

* Next.js
* TypeScript
* React

## DevOps

* Docker
* Docker Compose

## Observability

* OpenTelemetry (planned)
* Prometheus (planned)
* Grafana (planned)

---

# Project Structure

```text
src/main/java/com/tradecore/exchange

├── account/
├── wallet/
├── order/
├── trade/
├── matching/
├── ledger/
├── market/
├── common/
├── config/
└── security/
```

---

# Running the Project

## Prerequisites

* Java 21
* Docker Desktop
* PostgreSQL (via Docker)
* Maven

## Start PostgreSQL

```bash
docker compose up -d
```

## Run the application

```bash
./mvnw spring-boot:run
```

## Run tests

```bash
./mvnw test
```
---

# Future Enhancements

* JWT Authentication
* Role-based access control
* Multi-symbol trading
* Risk management
* Audit logging
* Event sourcing
* Horizontal scaling
* Kubernetes deployment
* FIX protocol gateway
* Performance benchmarking with JMH

---
