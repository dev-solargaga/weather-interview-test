# Vue + Java Spring Boot Variant

Backend requirements: Java 21 and Maven 3.9+

Open two Windows CMD windows.

Backend:

```cmd
cd /d <project-folder>\vue-java\backend
mvn spring-boot:run
```

Frontend:

```cmd
cd /d <project-folder>\vue-java\frontend
npm install
npm run dev
```

Frontend: `http://localhost:5173`  
Backend: `http://localhost:8080`  
API example: `http://localhost:8080/api/weather?city=Singapore`
