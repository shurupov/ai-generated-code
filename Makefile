# Build the backend Docker image
build-backend:
	docker build -t math-evaluator-backend -f backend/Dockerfile .

# Run the backend container (standalone)
run-backend:
	docker run -d -p 8080:8080 --name math-evaluator-backend math-evaluator-backend

# Stop and remove the backend container (standalone)
stop-backend:
	docker stop math-evaluator-backend || true
	docker rm math-evaluator-backend || true

# Full pipeline: build and run standalone
up: build-backend stop-backend run-backend

# --- Docker Compose commands ---

# Start all services (fast start using existing images)
compose-up:
	docker compose up -d

# Start all services and force rebuild
compose-up-build:
	docker compose up -d --build

# Stop all services
down-all:
	docker compose down

.PHONY: build-backend run-backend stop-backend up compose-up compose-up-build down-all
