@echo off
SETLOCAL

if "%1"=="up" goto up
if "%1"=="up-build" goto up-build
if "%1"=="down" goto down

:help
echo ============================================================
echo   Math Evaluator - Windows Management Script
echo ============================================================
echo.
echo Usage: manage.bat [up ^| up-build ^| down]
echo.
echo   up        - Start all services (fast start)
echo   up-build  - Start all services and force rebuild
echo   down      - Stop all services
echo.
echo ============================================================
goto end

:up
docker compose up -d
echo.
echo Application is running!
echo Frontend: http://localhost:3000
echo Swagger UI: http://localhost:8081
echo Backend API: http://localhost:8080
echo -----------------------------------
goto end

:up-build
docker compose up -d --build
echo.
echo Application rebuilt and running!
echo Frontend: http://localhost:3000
echo Swagger UI: http://localhost:8081
echo Backend API: http://localhost:8080
echo -----------------------------------
goto end

:down
docker compose down
echo.
echo All services stopped.
goto end

:end
ENDLOCAL
