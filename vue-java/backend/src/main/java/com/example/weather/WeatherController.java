package com.example.weather;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class WeatherController {

    @GetMapping("/weather")
    public Map<String, Object> getWeather(@RequestParam String city) {
        try {
            RestClient client = RestClient.create();

            String geocodingUrl = UriComponentsBuilder
                    .fromUriString("https://geocoding-api.open-meteo.com/v1/search")
                    .queryParam("name", city)
                    .queryParam("count", 1)
                    .queryParam("language", "en")
                    .toUriString();

            Map<?, ?> geocodingResponse = client.get()
                    .uri(geocodingUrl)
                    .retrieve()
                    .body(Map.class);

            List<?> results = (List<?>) geocodingResponse.get("results");
            if (results == null || results.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found");
            }

            Map<?, ?> location = (Map<?, ?>) results.get(0);
            Number latitude = (Number) location.get("latitude");
            Number longitude = (Number) location.get("longitude");

            String forecastUrl = UriComponentsBuilder
                    .fromUriString("https://api.open-meteo.com/v1/forecast")
                    .queryParam("latitude", latitude)
                    .queryParam("longitude", longitude)
                    .queryParam("current", "temperature_2m,apparent_temperature,weather_code,wind_speed_10m")
                    .queryParam("timezone", "auto")
                    .toUriString();

            Map<?, ?> forecastResponse = client.get()
                    .uri(forecastUrl)
                    .retrieve()
                    .body(Map.class);

            Map<?, ?> current = (Map<?, ?>) forecastResponse.get("current");
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("location", location.get("name") + ", " + location.get("country"));
            response.put("temperature", current.get("temperature_2m"));
            response.put("apparentTemperature", current.get("apparent_temperature"));
            response.put("weatherCode", current.get("weather_code"));
            response.put("windSpeed", current.get("wind_speed_10m"));
            return response;
        } catch (ResponseStatusException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}
