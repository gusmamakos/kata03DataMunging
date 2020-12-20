package com.mamakos;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataImportUntil {

    public static <T> List<T> getResults(String filename, String patternString,Class<T> clazz) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        File file = new File(filename);
        Pattern pattern = Pattern.compile(patternString);
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<T> results = new ArrayList<>();
        String string;
        while ((string = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                results.add(clazz.getConstructor(String.class, int.class, int.class).newInstance(matcher.group(1), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))));
            }
        }
        return results;
    }


}
