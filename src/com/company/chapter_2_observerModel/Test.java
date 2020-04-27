package com.company.chapter_2_observerModel;

import com.company.chapter_2_observerModel.observer.CurrentConditionsDisplay;
import com.company.chapter_2_observerModel.subject.WeatherData;

public class Test {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setData(123,35,67);

    }
}