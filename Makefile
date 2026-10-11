# --- Docker Compose commands ---

# Start all services (fast start using existing images)
compose-up:
	docker compose up -d
	@echo "\n🚀 Application is running!"
	@echo "Frontend: http://localhost:3000"
	@echo "Swagger UI: http://localhost:8081"
	@echo "Backend API: http://localhost:8080"
	@echo "-----------------------------------\n"

# Start all services and force rebuild
compose-up-build:
	docker compose up -d --build
	@echo "\n🚀 Application rebuilt and running!"
	@echo "Frontend: http://localhost:3000"
	@echo "Swagger UI: http://localhost:8081"
	@echo "Backend API: http://localhost:8080"
	@echo "-----------------------------------\n"

# Stop all services
down-all:
	docker compose down

.PHONY: compose-up compose-up-build down-all
