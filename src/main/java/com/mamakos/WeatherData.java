package com.mamakos;

public class WeatherData implements Statistics {
    private  String day;
    private  int high;
    private  int low;

    public WeatherData(String day, int high, int low) {
        this.day = day;
        this.high = high;
        this.low = low;
    }

    public int getSpread() {
        return high - low;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "day=" + day +
                ", high=" + high +
                ", low=" + low +
                ", spread=" + getSpread() +
                '}';
    }
}
