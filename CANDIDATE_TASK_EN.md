# Candidate Task: Weather Search Application

You have inherited a small full-stack weather application.

The application can already search for a city and display basic current-weather information. However, it was completed quickly and contains several areas that can be improved.

Your task is to improve the application into a more complete and reliable weather-search experience.

## Objective

Build a weather page that allows a user to search for a city and view:

- the resolved city and country;
- current weather conditions;
- a multi-day weather forecast;
- clear loading, empty, and error states.

The frontend must communicate only with the local backend. It must not call Open-Meteo directly.

## Required tasks

### 1. Run and inspect the application

Run both the frontend and backend locally.

Review the existing implementation and identify issues related to:

- code quality;
- API design;
- user experience;
- validation;
- error handling;
- reliability;
- maintainability.

Before making changes, briefly explain:

- what you believe the main problems are;
- which improvements you plan to make;
- why you selected those improvements.

### 2. Improve the city search

The user must be able to search for a city by name.

The application should:

- reject an empty search;
- trim unnecessary spaces;
- handle unknown cities;
- prevent repeated submissions while a request is in progress;
- show a clear loading state;
- show a useful error message when the request fails.

You may also add:

- search debouncing;
- request cancellation;
- recent searches;
- search suggestions.

### 3. Display current weather

Display the following information:

- resolved city name;
- country;
- temperature;
- apparent temperature;
- wind speed;
- weather code or a user-friendly weather description;
- date and local time, where available.

The page should remain usable when some weather fields are missing.

### 4. Display a multi-day forecast

Add a forecast section showing at least the next five days.

Each forecast day should display:

- date or day name;
- minimum temperature;
- maximum temperature;
- weather code or weather description;
- precipitation probability, if available;
- wind information, if available.

The forecast should be presented in a clear and readable layout.

### 5. Improve the backend

The backend must:

- accept the city name from the frontend;
- retrieve the location from Open-Meteo geocoding;
- retrieve current and daily forecast data from Open-Meteo;
- return a clean response designed for the frontend;
- return suitable HTTP status codes;
- handle upstream timeouts and errors;
- avoid exposing raw third-party errors directly to the user.

You should consider separating:

- route or controller logic;
- weather-service logic;
- response models;
- external API handling.

A full architectural rewrite is not required.

### 6. Verification

Verify the application using at least these cases:

1. A valid city, such as `Singapore`
2. Another valid city in a different country
3. An unknown city
4. An empty search
5. A search containing additional spaces
6. A simulated or real backend/API failure
7. Multiple searches performed quickly

Be prepared to explain how each case behaves.

## Optional extensions

Choose one or more extensions that demonstrate your strengths:

- Celsius and Fahrenheit switching;
- accessibility improvements;
- responsive mobile layout;
- weather icons;
- automated frontend tests;
- automated backend tests;
- caching;
- API documentation;
- Docker support;
- recent-search history;
- request cancellation;
- timezone-aware display;
- hourly forecast;
- localisation.

Do not rebuild the entire project unless you can justify why that is the best use of the interview time.

## Expected deliverables

At the end of the exercise, provide:

- the updated source code;
- a short summary of the issues you identified;
- a list of the changes you made;
- instructions for running the application;
- a short explanation of how you tested it;
- any known limitations or unfinished items.

## Discussion topics

Be prepared to explain:

- what you changed;
- why you prioritised those changes;
- how the frontend and backend communicate;
- how you handled invalid input and API failures;
- how you designed the forecast response;
- how you verified the application;
- what you would improve next with more time.

## Use of AI tools

Use of AI tools is permitted.

Before asking AI to make changes, you must first explain:

- your understanding of the problem;
- the solution you propose;
- which part you intend to ask AI to help with.

After using AI, you remain responsible for:

- reviewing the generated code;
- testing the changes;
- verifying that the implementation works;
- understanding and explaining the final solution.

The use of AI will be assessed fairly and in context. Candidates will not be penalised simply for using AI. We will evaluate whether AI was used appropriately, whether the candidate understood the proposed solution, and whether the candidate was able to review, test, verify, and explain the final code.
