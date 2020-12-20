package com.mamakos;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) throws IOException {

    List<FootballData> footballStats = new ArrayList<>();
    //    2. Liverpool       38    24   8   6    67  -  30    80
    Pattern pattern = Pattern.compile("^\\s+\\d+\\.\\s(\\w+)\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+\\s+(\\d+)\\s+-\\s+(\\d+)\\s+\\d+$");
    Matcher matcher;

    try {
        File file = new File("football.dat");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string;
        while ((string = br.readLine()) != null) {
            matcher = pattern.matcher(string);
            if (matcher.find()) {
                footballStats.add(new FootballData(matcher.group(1),Integer.parseInt(matcher.group(2)),Integer.parseInt(matcher.group(3))));
            }
        }
    } catch (
    FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
    }
    Comparator<FootballData> comparator = Comparator.comparing( FootballData::getSpread );
    FootballData minSpread = footballStats.stream().min(comparator).orElse(null);
        System.out.println(minSpread);
    }
}

