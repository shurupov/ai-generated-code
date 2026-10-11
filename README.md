# Math Expression Evaluator

A full-stack application for evaluating mathematical expressions. It consists of a Spring Boot backend, a React frontend with an auto-generated API client, and Swagger UI for API documentation.

[Русская версия (RU)](README_RU.md)

## 🤖 AI Generation
This entire project was generated with the help of **Ollama** using the **gemma4:31b-cloud** model.

## 🚀 Tech Stack

- **Backend:** Java 17, Spring Boot
- **Frontend:** React, TypeScript, Vite, Axios
- **API Documentation:** OpenAPI 3.0 (Swagger UI)
- **Infrastructure:** Docker, Docker Compose

## 🛠 Getting Started

### Prerequisites
- [Docker](https://www.docker.com/products/docker-desktop/)
- [Docker Compose](https://docs.docker.com/compose/)

### Installation and Launch

#### For Linux / macOS (using Makefile)
1. **Fast start** (using existing images):
   ```bash
   make compose-up
   ```
2. **Start with full rebuild** (after code or schema changes):
   ```bash
   make compose-up-build
   ```
3. **Stop all services**:
   ```bash
   make down-all
   ```

#### For Windows (using manage.bat)
1. **Fast start**:
   ```cmd
   manage.bat up
   ```
2. **Start with full rebuild**:
   ```cmd
   manage.bat up-build
   ```
3. **Stop all services**:
   ```cmd
   manage.bat down
   ```

## 🌐 Application URLs

| Service | URL | Description |
| :--- | :--- | :--- |
| **Frontend** | [http://localhost:3000](http://localhost:3000) | User interface for calculations |
| **Swagger UI** | [http://localhost:8081](http://localhost:8081) | Interactive API documentation |
| **Backend API** | [http://localhost:8080](http://localhost:8080) | Core evaluation engine |

## ⚙️ How it Works
The frontend API client is automatically generated from the `api/openapi.yaml` specification using the `openapi-generator-cli`. This ensures that the frontend always stays in sync with the backend API.
