# Candidate Task: Weather Application

This is a short live coding assessment covering a Vue frontend and a local backend.

## Time Allocation

- 15 minutes before the assessment: install dependencies and start the project
- 60 minutes: complete the coding exercise
- A major UI redesign is not required; a simple and usable interface is sufficient
- This assessment places greater emphasis on backend ability

## Your Task

## Full-Stack Tasks

### FS1: Air Quality

Use the Open-Meteo Air Quality API and display:

- AQI, with the AQI standard clearly identified
- PM2.5
- PM10

Use the coordinates already resolved by the backend.

If the air-quality request fails, the weather result must still remain visible.

### FS2: Multiple Cities with the Same Name

- The backend should return up to five matching locations
- The frontend should display the city, region, and country
- The user should be able to select the intended location
- Weather should be retrieved for the selected location
- The frontend must not call Open-Meteo directly

### FS3: AI Weather Advice

Add an AI-related programming task without using a real AI API or model, which is already provided.

### Task Path

Complete:

- 1 full-stack task
- 1 backend or frontend task

Important: the existing city weather search only needs to continue working correctly.

## Frontend Tasks

Choose 1.

### FE1: Validation and Feedback

- Trim leading and trailing spaces from the city input
- Prevent empty searches
- Show loading and error states
- Prevent repeated submissions
- Distinguish between “city not found” and “backend failure”

### FE2: Debounced Search

- Search after the user stops typing
- Avoid empty and unnecessary requests
- Prevent an older response from replacing a newer response

### FE3: Recent Search History

- Use browser storage
- Save only successful searches
- Keep a maximum of five entries
- Remove case-insensitive duplicates
- Allow the user to search a previous city again
- Safely handle corrupted stored data

## Backend Tasks

Choose 1.

### BE1: Validation and Error Handling

- Validate and normalise the city input
- Reject empty input
- Use appropriate HTTP status codes
- Return consistent error responses
- Do not expose raw exceptions to the frontend

### BE2: External API Reliability

- Add timeouts to Open-Meteo requests
- Handle connection failures and timeouts
- Handle missing or malformed upstream data
- Add useful logging
- Return safe error messages to the frontend

### BE3: In-Memory Caching

- Cache successful weather results
- Normalise cache keys
- Use a configurable expiry time
- Do not cache failed requests
- Allow the candidate to demonstrate cache hits and cache misses

## Mock AI Service

Please use the mock AI services provided in both backend implementations:

- Python/FastAPI
- Java/Spring Boot

The mock service should accept current-weather data and return a structure similar to:

```json
{
  "summary": "Warm and windy conditions.",
  "recommendation": "Stay hydrated when outdoors.",
  "riskLevel": "medium"
}
