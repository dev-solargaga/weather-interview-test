# Candidate Task: Weather Application

The application already supports city search and current-weather display.

You will have:

* 15 minutes before the test to install dependencies and run the project
* 60 minutes for the coding exercise

This is not a UI design exercise. A simple and usable interface is sufficient.

## Your Task

Complete:

1. **AI Weather Advice**

If there are additional time, complete below in order:

2. **One backend task**
3. **One frontend task**

You do not need to complete any other tasks.

The existing weather search must continue to work.

---

# Required Full-Stack Task

## AI Weather Advice

A mock AI weather service is already provided.

It accepts current-weather data and may return:

```json
{
  "summary": "Warm and windy conditions.",
  "recommendation": "Stay hydrated when outdoors.",
  "riskLevel": "medium"
}
```

### Backend

* Call the mock AI service using the current-weather data
* Treat its output as untrusted
* Validate `summary` and `recommendation`
* Accept only `low`, `medium`, or `high` for `riskLevel`
* Handle malformed output, missing fields and service failure
* Return a safe fallback without breaking the weather result
* Do not replace factual weather values with AI-generated content

### Frontend

Display:

* Summary
* Recommendation
* Risk level

The factual weather result must remain visible if AI advice is unavailable.

---

# Frontend Tasks

Choose one.

## FE1: Validation and Feedback

* Trim city input
* Prevent empty searches
* Show loading and error states
* Prevent repeated submissions
* Distinguish city-not-found from backend failure

## FE2: Debounced Search

* Search after the user stops typing
* Avoid empty and unnecessary requests
* Prevent an older response from replacing a newer result

---

# Backend Tasks

Choose one.

## BE1: Validation and Errors

* Validate and normalise city input
* Reject empty input
* Use suitable HTTP status codes
* Return consistent error responses
* Do not expose raw exceptions

## BE2: External API Reliability

* Add timeouts to Open-Meteo requests
* Handle connection failures and timeouts
* Handle missing or malformed API data
* Add useful backend logging
* Return safe errors to the frontend

---

# At the End Of Every Task

Be prepared to explain:

* what you changed;
* how you validated the mock AI output;
* why you selected the frontend and backend tasks;
* how you tested your changes;
* what remains incomplete;
* what you would improve with more time.

AI tools may be used, but you must understand, test and explain all generated code.
