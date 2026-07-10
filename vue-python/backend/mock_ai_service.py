from typing import Any
import os


class MockAIWeatherService:
    """Interview scaffolding: a deterministic mock AI service for candidates to integrate."""

    def __init__(self, mode: str | None = None) -> None:
        self.mode = (mode or os.getenv("MOCK_AI_MODE", "valid")).strip().lower()

    def generate_advice(
        self,
        weather_data: dict[str, Any] | None = None,
        mode: str | None = None,
    ) -> dict[str, Any]:
        selected_mode = (mode or self.mode).strip().lower()

        if selected_mode == "malformed":
            return {
                "summary": "Warm and windy conditions.",
                "recommendation": 42,
                "riskLevel": "medium",
            }

        if selected_mode == "missing-field":
            return {
                "summary": "Warm and windy conditions.",
                "riskLevel": "medium",
            }

        if selected_mode == "invalid-risk-level":
            return {
                "summary": "Warm and windy conditions.",
                "recommendation": "Stay hydrated when outdoors.",
                "riskLevel": "urgent",
            }

        if selected_mode == "timeout":
            raise TimeoutError("Mock AI service timed out")

        temperature = self._extract_temperature(weather_data)
        summary = "Hot and sunny conditions." if temperature is not None and temperature > 25 else "Warm and windy conditions."
        return {
            "summary": summary,
            "recommendation": "Stay hydrated when outdoors.",
            "riskLevel": "medium",
        }

    def _extract_temperature(self, weather_data: dict[str, Any] | None = None) -> float | None:
        if not weather_data:
            return None

        temperature = weather_data.get("temperature")
        if isinstance(temperature, (int, float)):
            return float(temperature)
        return None
