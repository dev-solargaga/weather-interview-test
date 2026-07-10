@echo off
setlocal
set "MVNW_DIR=%~dp0"
set "MAVEN_VERSION=3.9.11"
set "MAVEN_HOME=%MVNW_DIR%.mvn\apache-maven-%MAVEN_VERSION%"
set "MAVEN_ZIP=%MVNW_DIR%.mvn\apache-maven-%MAVEN_VERSION%-bin.zip"
set "MAVEN_URL=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/%MAVEN_VERSION%/apache-maven-%MAVEN_VERSION%-bin.zip"

where java >nul 2>nul
if errorlevel 1 (
  echo ERROR: Java was not found. Install Java 21 and restart VS Code.
  exit /b 1
)

if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
  echo Maven %MAVEN_VERSION% was not found locally. Downloading it now...
  powershell -NoProfile -ExecutionPolicy Bypass -Command "$ProgressPreference='SilentlyContinue'; Invoke-WebRequest -Uri '%MAVEN_URL%' -OutFile '%MAVEN_ZIP%'"
  if errorlevel 1 (
    echo ERROR: Maven download failed. Check the internet connection and try again.
    exit /b 1
  )
  powershell -NoProfile -ExecutionPolicy Bypass -Command "Expand-Archive -Path '%MAVEN_ZIP%' -DestinationPath '%MVNW_DIR%.mvn' -Force"
  if errorlevel 1 (
    echo ERROR: Maven extraction failed.
    exit /b 1
  )
  del /q "%MAVEN_ZIP%" >nul 2>nul
)

call "%MAVEN_HOME%\bin\mvn.cmd" %*
exit /b %errorlevel%
