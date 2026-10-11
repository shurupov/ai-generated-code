# Build stage
FROM node:20-alpine AS build

# Install OpenJDK JRE for openapi-generator-cli
RUN apk add --no-cache openjdk21-jre-headless

WORKDIR /app

# Copy package files from frontend folder
COPY frontend/package*.json ./
RUN npm install

# Copy api folder for generation
COPY api ./api

# Copy frontend source
COPY frontend ./frontend

# Set working directory to frontend for build commands
WORKDIR /app/frontend
RUN npm run build

# Production stage
FROM nginx:stable-alpine
COPY --from=build /app/frontend/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
