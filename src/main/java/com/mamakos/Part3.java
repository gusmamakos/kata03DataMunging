package com.mamakos;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;

public class Part3 {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Comparator<Statistics> comparator = Comparator.comparing( Statistics::getSpread );

        List<WeatherData> weatherList = DataImportUntil.getResults("weather.dat", "^\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)", WeatherData.class);
        System.out.println(weatherList.stream().min(comparator));

        List<FootballData> footballList = DataImportUntil.getResults("football.dat", "^\\s+\\d+\\.\\s(\\w+)\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+\\s+(\\d+)\\s+-\\s+(\\d+)\\s+\\d+$", FootballData.class);
        System.out.println(footballList.stream().min(comparator));

    }
}
