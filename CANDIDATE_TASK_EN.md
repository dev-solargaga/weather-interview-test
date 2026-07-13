# Candidate Task: Weather Application

This is a short live coding assessment involving a Vue frontend and a local backend.

## Time Allocation

- 15 minutes before the assessment: install dependencies and start the project
- 60 minutes: complete the coding exercise
- A major UI redesign is not required; a simple and usable interface is sufficient
- This assessment focuses primarily on backend ability, AI integration, validation, and reliability
- You may update the frontend where necessary to complete the required full-stack task

## Required Work

Complete:

1. **FS: AI Weather Advice**
2. **One backend task**

If time remains, you may complete one frontend task or one optional full-stack extension.

Important: the existing city weather search must continue to work correctly.

---

## Required Full-Stack Task

### FS: AI Weather Advice

A deterministic mock AI weather service is already provided in the assigned backend implementation:

- Python/FastAPI
- Java/Spring Boot

The mock service accepts factual current-weather data and may return:

- `summary`
- `recommendation`
- `riskLevel`

A valid response contains:

- `summary`: a short description of the weather conditions
- `recommendation`: practical advice for the user
- `riskLevel`: `low`, `medium`, or `high`

#### Backend Requirements

- Call the provided mock AI service using the factual current-weather data
- Treat all AI-generated output as untrusted
- Validate that `summary` is a non-empty string
- Validate that `recommendation` is a non-empty string
- Accept only `low`, `medium`, or `high` for `riskLevel`
- Handle malformed output
- Handle missing fields
- Handle invalid risk levels
- Handle service failures, timeouts, or exceptions
- Return a safe fallback without breaking the normal weather response
- Ensure that AI-generated content does not replace or modify factual weather values

#### Frontend Requirements

Display the following in a simple section:

- Summary
- Recommendation
- Risk level

The factual weather result must remain visible if the AI advice is invalid or unavailable.

#### Required Verification

Demonstrate the behaviour for at least:

- Valid AI output
- Missing fields
- Invalid risk level
- Malformed output
- Service exception or timeout

Do not replace the provided mock service with a real AI API or model.

Do not introduce:

- A real OpenAI dependency
- An API key
- An external AI service

---

## Backend Tasks

Choose one.

### BE1: Validation and Error Handling

- Validate and normalise the city input
- Trim unnecessary leading and trailing spaces
- Reject empty input
- Use appropriate HTTP status codes
- Return consistent error responses
- Do not expose raw exceptions to the frontend

### BE2: External API Reliability

- Add explicit timeouts to Open-Meteo requests
- Handle connection failures and request timeouts
- Handle missing or malformed upstream data
- Add useful backend logging
- Return safe and understandable error responses to the frontend

### BE3: In-Memory Caching

- Cache successful weather results
- Normalise cache keys
- Use a configurable expiry time
- Do not cache failed requests
- Allow cache hits and cache misses to be demonstrated
- Consider thread safety or concurrent requests where relevant

---

## Optional Frontend Tasks

These tasks are optional unless frontend changes are required to complete FS.

If time remains, choose one.

### FE1: Validation and Feedback

- Trim leading and trailing spaces from the city input
- Prevent empty searches
- Show loading and error states
- Prevent repeated submissions while a request is in progress
- Distinguish between “city not found” and “backend failure”

### FE2: Debounced Search

- Search after the user stops typing
- Avoid empty and unnecessary requests
- Prevent an older response from replacing a newer result
- Cancel or safely ignore stale requests

### FE3: Recent Search History

- Use browser storage
- Save only successful searches
- Keep a maximum of five entries
- Remove case-insensitive duplicates
- Allow the user to search a previous city again
- Safely handle missing or corrupted stored data

---

## AI-Assisted Development Expectations

AI tools may be used.

Before asking AI to modify the code, explain:

- Your understanding of the problem
- Your proposed solution
- The files or logic you expect to change
- The risks and edge cases you intend to verify

After using AI, you remain responsible for:

- Reviewing all generated changes
- Rejecting or correcting unsuitable suggestions
- Running the application
- Testing successful and unsuccessful scenarios
- Verifying that existing behaviour still works
- Understanding and explaining the final implementation

You may be asked to show or summarise how you used AI during the exercise.

The use of AI will be assessed fairly and in context. You will not be penalised simply for using AI. We will evaluate whether it was used appropriately and whether you understood, tested, verified, and could explain the resulting code.

---

## End-of-Task Discussion

Be prepared to explain:

- What you changed
- Why you selected that backend task
- How you integrated the mock AI service
- How you validated the AI output
- How the application behaves when the AI service fails
- What AI-generated suggestions you accepted, modified, or rejected
- How you tested your work
- Which parts remain incomplete
- What you would improve with more time

## Bonus

Focused manual checks are welcome.

Automated tests are valuable but are not required within the one-hour exercise.
```
