package com.example.weatherapp.service;

import com.example.weatherapp.model.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import java.io.IOException;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_KEY = "bd5e378503939ddaee76f12ad7a97608";

    public WeatherResponse getWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                     "&appid=" + API_KEY + "&units=metric";
        Map<String, Object> data = restTemplate.getForObject(url, Map.class);
        return new WeatherResponse(city, data);
    }
}
