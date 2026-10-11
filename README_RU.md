# Math Expression Evaluator (Вычислитель математических выражений)

Полнофункциональное приложение для вычисления математических выражений. Состоит из бэкенда на Spring Boot, фронтенда на React с автоматически генерируемым API-клиентом и Swagger UI для документации API.

[English version (EN)](README.md)

## 🤖 Генерация с помощью ИИ
Весь этот проект был сгенерирован с помощью **Ollama** и модели **gemma4:31b-cloud**.

## 🚀 Технологический стек

- **Бэкенд:** Java 17, Spring Boot
- **Фронтенд:** React, TypeScript, Vite, Axios
- **Документация API:** OpenAPI 3.0 (Swagger UI)
- **Инфраструктура:** Docker, Docker Compose

## 🛠 Быстрый старт

### Требования
- [Docker](https://www.docker.com/products/docker-desktop/)
- [Docker Compose](https://docs.docker.com/compose/)

### Установка и запуск

#### Для Linux / macOS (через Makefile)
1. **Быстрый запуск** (используя существующие образы):
   ```bash
   make compose-up
   ```
2. **Запуск с полной пересборкой** (после изменений в коде или схеме):
   ```bash
   make compose-up-build
   ```
3. **Остановка всех сервисов**:
   ```bash
   make down-all
   ```

#### Для Windows (через manage.bat)
1. **Быстрый запуск**:
   ```cmd
   manage.bat up
   ```
2. **Запуск с полной пересборкой**:
   ```cmd
   manage.bat up-build
   ```
3. **Остановка всех сервисов**:
   ```cmd
   manage.bat down
   ```

## 🌐 Адреса приложения

| Сервис | URL | Описание |
| :--- | :--- | :--- |
| **Фронтенд** | [http://localhost:3000](http://localhost:3000) | Пользовательский интерфейс |
| **Swagger UI** | [http://localhost:8081](http://localhost:8081) | Интерактивная документация API |
| **Бэкенд API** | [http://localhost:8080](http://localhost:8080) | Ядро вычислений |

## ⚙️ Как это работает
API-клиент фронтенда автоматически генерируется из спецификации `api/openapi.yaml` с помощью `openapi-generator-cli`. Это гарантирует, что фронтенд всегда синхронизирован с API бэкенда.
