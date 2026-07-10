# Java Backend

## Requirements

- Java 21
- Internet access for the initial Maven and dependency download

Maven does not need to be installed separately. This backend includes `mvnw.cmd`, which downloads Maven automatically on first use.

## Run in the VS Code PowerShell terminal

Open the terminal in this `backend` directory and run:

```powershell
.\mvnw.cmd spring-boot:run
```

The first run may take a few minutes while Maven and the project dependencies are downloaded.

API example: `http://localhost:8080/api/weather?city=Singapore`
