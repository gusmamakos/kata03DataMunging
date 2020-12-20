package com.mamakos;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<WeatherData> forecasts = new ArrayList<>();
        Pattern pattern = Pattern.compile("^\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)");
        Matcher matcher;

        try {
            File file = new File("weather.dat");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String string;
            while ((string = br.readLine()) != null) {
                matcher = pattern.matcher(string);
                if (matcher.find()) {
                    forecasts.add(new WeatherData(matcher.group(1),Integer.parseInt(matcher.group(2)),Integer.parseInt(matcher.group(3))));
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        Comparator<WeatherData> comparator = Comparator.comparing( WeatherData::getSpread );
        WeatherData minSpread = forecasts.stream().min(comparator).orElse(null);
        System.out.println(minSpread);

    }
}

