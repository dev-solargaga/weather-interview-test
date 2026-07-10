# Candidate Task: Weather Application

You have inherited a small weather application built with Vue and a local backend.

The application already allows users to search for a city and view its current weather.

## Time

You will have:

* 15 minutes before the test to install dependencies and run the project
* 60 minutes for the coding exercise

This is not a UI design exercise. A simple and usable interface is enough.

## Your Task

Choose one route.

### Route A

Complete:

* 1 frontend task
* 2 backend tasks

### Route B

Complete:

* 1 full-stack task
* 1 backend task

You do not need to complete any tasks outside your selected route.

The existing city search must continue to work.

---

# Frontend Tasks

Choose one.

## FE1: Validation and Feedback

* Trim the city input
* Prevent empty searches
* Show loading and error states
* Prevent repeated submissions while loading
* Show different messages for “city not found” and backend failure

## FE2: Debounced Search

* Search after the user stops typing
* Do not search empty values
* Avoid unnecessary requests
* Prevent an older request from replacing a newer result

## FE3: Recent Searches

* Store successful searches in browser storage
* Keep a maximum of five cities
* Remove case-insensitive duplicates
* Allow a previous city to be searched again
* Handle invalid stored data safely

---

# Backend Tasks

Choose two for Route A, or one for Route B.

## BE1: Validation and Errors

* Trim and validate the city
* Reject empty input
* Return a suitable response when the city is not found
* Use consistent error responses
* Do not return raw exceptions to the frontend

## BE2: External API Reliability

* Add timeouts to Open-Meteo requests
* Handle connection and timeout failures
* Handle missing or invalid API data
* Add useful backend logging
* Return safe error messages to the frontend

## BE3: In-Memory Cache

* Cache successful weather results
* Use a normalised city name as the cache key
* Add a configurable expiry time
* Do not cache failed requests
* Demonstrate a cache hit and cache miss

---

# Full-Stack Tasks

Choose one for Route B.

The frontend must call only the local backend.

## FS1: Air Quality

Use Open-Meteo’s Air Quality API to display:

* AQI
* PM2.5
* PM10

Use the city coordinates already retrieved by the backend.

The weather result should still work if air-quality data is unavailable.

A simple additional section or card is enough.

## FS2: Multiple City Matches

Some city names can refer to multiple locations.

Instead of always using the first result:

* return up to five matching locations from the backend;
* display them in a simple list or dropdown;
* show the city, region and country;
* allow the user to select one;
* retrieve weather for the selected location.

---

# At the End

Be prepared to explain:

* what you changed;
* why you selected those tasks;
* how you tested them;
* what remains incomplete;
* what you would improve with more time.

Incomplete work is acceptable if you can clearly explain your approach.

## AI Tools

AI tools may be used, but you must understand, verify and explain the final code.
