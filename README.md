# 📓 ScribeVault API: Secure Journaling Backend

[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green.svg)](https://spring.io/projects/spring-boot)
[![Redis](https://img.shields.io/badge/Redis-Caching-red.svg)](https://redis.io/)
[![Build](https://img.shields.io/badge/Build-Maven-blue.svg)](https://maven.apache.org/)

**ScribeVault** is a production-grade REST API for a digital journaling platform. It is engineered with a focus on **security**, **performance**, and **scalability**. The system features role-based authentication, Redis caching for high-speed data retrieval, and external API integration to enrich journal entries with real-time weather context.

---

## 🚀 Key Features

* **🔐 Robust Security:** Implemented **Spring Security** with secure authentication flows to protect sensitive user data.
* **⚡ High-Performance Caching:** Integrated **Redis** to cache frequently accessed journal entries, significantly reducing database load and latency.
* **☁️ External Integrations:** Consumes third-party **Weather APIs** to automatically tag journal entries with location-based weather data.
* **🧪 Reliable Architecture:** * Follows a strict **Controller-Service-Repository** pattern.
    * Includes comprehensive unit testing using **Mockito** to ensure regression safety.
* **💾 Polyglot Persistence:** Uses **MySQL** for transactional data and **Redis** for ephemeral caching.

---

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3
* **Database:** MySQL (Relational), Redis (Caching)
* **Security:** Spring Security (Authentication/Authorization)
* **Testing:** JUnit 5, Mockito
* **Build Tool:** Maven

---

## 📂 Project Structure

The project follows a clean, modular architecture:

```text
src/main/java/com/neel/FinalJournal
├── 📂 api.response      # DTOs for external API responses (WeatherResponse)
├── 📂 cache             # Redis configuration and caching logic (AppCache)
├── 📂 config            # Security & Transaction configurations
├── 📂 controller        # REST Endpoints (Admin, Public, User, Journal)
├── 📂 entity            # JPA Entities (User, JournalEntry)
├── 📂 repository        # Database interaction interfaces
├── 📂 service           # Business logic layer
└── 📂 scheduler         # Cron jobs/Scheduled tasks
