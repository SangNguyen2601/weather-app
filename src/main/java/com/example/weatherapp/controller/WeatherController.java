package com.example.weatherapp.controller;

import com.example.weatherapp.model.WeatherResponse;
import com.example.weatherapp.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public ModelAndView showWeather(@RequestParam(defaultValue = "Tokyo") String city) {
        WeatherResponse weather = weatherService.getWeather(city);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("weather", weather);
        return mav;
    }
}
