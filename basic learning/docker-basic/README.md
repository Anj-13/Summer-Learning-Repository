# Docker Basic - Node.js Learning Project

This is a simple Node.js app with Docker for learning purposes. It uses Express.js and serves on port 9000.

## Prerequisites

- [Node.js](https://nodejs.org/) (v24) - for local development
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) (optional) - for containerized development

## Project Structure

```
docker-basic/
├── .dockerignore          # Files to exclude from Docker build
├── .gitignore             # Files to exclude from Git
├── dockerfile             # Docker build instructions
├── package.json           # Project metadata & dependencies
├── package-lock.json      # Locked dependency versions
├── README.md              # This file
└── src/
    └── Index.js           # Application entry point
```

## Local Development

Run the app directly on your machine (no Docker required).

1. Install dependencies:
   ```bash
   npm install
   ```

2. Start the development server:
   ```bash
   npm start
   ```

The app will be available at `http://localhost:9000`.

## Docker Development

Build and run the app inside a Docker container.

1. Build the Docker image:
   ```bash
   docker build -t docker-basic .
   ```

2. Run the container:
   ```bash
   docker run -p 9000:9000 docker-basic
   ```

The app will be available at `http://localhost:9000`.

## Scripts

| Command       | Description                    |
|---------------|--------------------------------|
| `npm install` | Install all dependencies       |
| `npm start`   | Run the app with Node.js       |
| `npm test`    | Run tests (not yet configured) |