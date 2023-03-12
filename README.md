# Music Streaming Aggregator

Music Streaming Aggregator is a work in progress web application that allows users to stream music from multiple sources while also providing data analysis on their listening habits. The application is built using Java Spring for the backend and React with Vite and Tailwind for the frontend.

# Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Running the Project](#running-the-project)
- [License](#license)

# Features
- Stream music from multiple sources
- Analyze listening habits with data visualization
- Personalized recommendations based on listening history
- Integration with popular music streaming services

# Getting Started

## Prerequisites

- Java 11 or higher
- Node.js 14 or higher
- NPM

## Installation

1. Clone the repository:

```bash
git clone https://github.com/george4591/Music-Streaming-Aggregator
```

2. Install the backend dependencies

```bash
cd music-streaming-aggregator/backend
mvn install
```
3. Compile the backend project 
```bash
mvn compile
mvn package
```
4. Install frontend dependencies:

```bash
cd ../frontend
npm install
```

# Running the Project
1. Start the backend server
```bash
cd music-streaming-aggregator/backend
java -jar target/backend-0.0.1-SNAPSHOT.jar
```
2. Start the frontend development server:
```bash
npm run dev
```
3. Access the application at http://localhost:5173 

# License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
