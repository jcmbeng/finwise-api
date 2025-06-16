# FinWise API – Core Banking Backend

![Java](https://img.shields.io/badge/Java-21-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)
![Docker](https://img.shields.io/badge/Docker-enabled-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16.x-blue.svg)
![CI/CD](https://img.shields.io/badge/CI/CD-GitHub%20Actions%20%26%20Jenkins-green)

> **FinWise** is a secure, modular, microservice-based core banking platform tailored for microfinance institutions.  
> This repository contains the backend services built with **Java 21**, **Spring Boot**, **Kafka**, **PostgreSQL**, and integrated with **Jenkins**, **Docker**, and **ELK Stack**.

---

## 🧱 Tech Stack

- **Java 21** + **Spring Boot 3+**
- **Microservices** architecture (REST + Kafka)
- **PostgreSQL** (per service DB schema)
- **Kafka** for asynchronous messaging
- **Docker** for containerization
- **Jenkins + GitHub Actions** for CI/CD
- **ELK Stack** for centralized logging
- **Keycloak** for authentication and authorization (OAuth2)
- **Prometheus + Grafana** for monitoring

---

## 🧩 Core Modules

| Module                 | Description                                     |
|------------------------|-------------------------------------------------|
| Customer Service       | KYC, onboarding, document management            |
| Account Service        | Savings, checking, term deposit accounts       |
| Loan Service           | Loan creation, repayment, amortization         |
| Transaction Service    | Transfers, deposits, withdrawals                |
| Treasury Service       | GL accounting, reconciliation                   |
| Reporting Service      | KPI dashboards, regulatory reports              |
| Mobile Money Service   | MTN MoMo, Orange Money integration              |
| Configuration Service  | Fees, interest rate setup                       |

---

## 🚀 Getting Started

### Prerequisites

- Java 21
- Docker & Docker Compose
- PostgreSQL 15
- Kafka / Zookeeper
- Redis (optional)
- Keycloak (for auth)

### Run Locally (Dev Mode)

```bash
git clone [https://github.com/jcmbeng/finwise-api.git]
cd finwise-api

# Start all services using Docker
docker-compose up --build
