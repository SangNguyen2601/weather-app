package com.example.weatherapp.model;

import java.util.Map;

public class WeatherResponse {
    private String city;
    private Double temperature;
    private Double latitude;
    private Double longitude;

    public WeatherResponse(String city, Map<String, Object> data) {
        this.city = city;
        this.temperature = ((Map<String, Double>) data.get("main")).get("temp");
        Map<String, Double> coord = (Map<String, Double>) data.get("coord");
        this.latitude = coord.get("lat");
        this.longitude = coord.get("lon");
    }

    public String getCity() {
        return city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
