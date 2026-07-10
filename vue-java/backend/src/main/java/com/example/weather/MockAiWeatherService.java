package com.example.weather;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * Interview scaffolding: a deterministic mock AI weather service.
 *
 * The return type is intentionally Object so candidates must treat the
 * AI-style output as untrusted and validate both the top-level type
 * and individual fields.
 */
@Service
public class MockAiWeatherService {

    public static final String MODE_VALID = "valid";
    public static final String MODE_MALFORMED = "malformed";
    public static final String MODE_MISSING_FIELD = "missing-field";
    public static final String MODE_INVALID_RISK_LEVEL = "invalid-risk-level";
    public static final String MODE_TIMEOUT = "timeout";

    private static final String DEFAULT_MODE = MODE_VALID;

    public Object generateAdvice(Map<String, Object> weatherData) {
        return generateAdvice(weatherData, DEFAULT_MODE);
    }

    public Object generateAdvice(
            Map<String, Object> weatherData,
            String mode
    ) {
        String selectedMode = normalizeMode(mode);

        return switch (selectedMode) {
            case MODE_MALFORMED ->
                    "This is not a structured AI response.";

            case MODE_MISSING_FIELD ->
                    Map.of(
                            "summary", "Warm and windy conditions.",
                            "riskLevel", "medium"
                    );

            case MODE_INVALID_RISK_LEVEL ->
                    Map.of(
                            "summary", "Warm and windy conditions.",
                            "recommendation", "Stay hydrated when outdoors.",
                            "riskLevel", "urgent"
                    );

            case MODE_TIMEOUT ->
                    throw new IllegalStateException(
                            "Simulated AI service timeout"
                    );

            case MODE_VALID ->
                    createValidAdvice(weatherData);

            default ->
                    throw new IllegalArgumentException(
                            "Unsupported mock AI mode: " + selectedMode
                    );
        };
    }

    private String normalizeMode(String mode) {
        if (mode == null || mode.isBlank()) {
            return DEFAULT_MODE;
        }

        return mode.trim().toLowerCase(Locale.ROOT);
    }

    private Map<String, Object> createValidAdvice(
            Map<String, Object> weatherData
    ) {
        LinkedHashMap<String, Object> advice = new LinkedHashMap<>();

        advice.put("summary", describeWeather(weatherData));
        advice.put(
                "recommendation",
                "Stay hydrated when outdoors."
        );
        advice.put("riskLevel", "medium");

        return advice;
    }

    private String describeWeather(
            Map<String, Object> weatherData
    ) {
        Object temperature = weatherData == null
                ? null
                : weatherData.get("temperature");

        if (temperature instanceof Number number
                && number.doubleValue() > 25) {
            return "Hot and sunny conditions.";
        }

        return "Warm and windy conditions.";
    }
}