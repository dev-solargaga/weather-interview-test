from typing import Any

import requests
from fastapi import FastAPI, HTTPException, Query
from fastapi.middleware.cors import CORSMiddleware

from mock_ai_service import MockAIWeatherService

app = FastAPI(title="Weather Interview API")
mock_ai_service = MockAIWeatherService()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


@app.get("/api/weather")
async def get_weather(city: str = Query(...)) -> dict[str, Any]:
    return await _get_weather(city, include_ai=False)


@app.get("/api/weather/ai")
async def get_weather_with_ai(city: str = Query(...), mode: str | None = None) -> dict[str, Any]:
    return await _get_weather(city, include_ai=True, mode=mode)


async def _get_weather(city: str, include_ai: bool = False, mode: str | None = None) -> dict[str, Any]:
    try:
        geocoding_response = requests.get(
            "https://geocoding-api.open-meteo.com/v1/search",
            params={"name": city, "count": 1, "language": "en"},
        )
        geocoding_response.raise_for_status()
        results = geocoding_response.json().get("results")

        if not results:
            raise HTTPException(status_code=404, detail="City not found")

        location = results[0]
        forecast_response = requests.get(
            "https://api.open-meteo.com/v1/forecast",
            params={
                "latitude": location["latitude"],
                "longitude": location["longitude"],
                "current": "temperature_2m,apparent_temperature,weather_code,wind_speed_10m",
                "timezone": "auto",
            },
        )
        forecast_response.raise_for_status()
        current = forecast_response.json()["current"]

        response = {
            "location": f'{location["name"]}, {location["country"]}',
            "temperature": current["temperature_2m"],
            "apparentTemperature": current["apparent_temperature"],
            "weatherCode": current["weather_code"],
            "windSpeed": current["wind_speed_10m"],
        }

        if include_ai:
            try:
                response["aiAdvice"] = mock_ai_service.generate_advice(response, mode=mode)
            except Exception as exception:
                response["aiAdvice"] = {"error": "Mock AI service unavailable"}

        return response
    except HTTPException:
        raise
    except Exception as exception:
        raise HTTPException(status_code=500, detail=str(exception)) from exception
