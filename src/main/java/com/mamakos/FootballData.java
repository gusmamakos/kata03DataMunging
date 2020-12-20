package com.mamakos;

public class FootballData implements Statistics{
    private String name;
    private int pointsFor;
    private int pointsAgainst;

    public FootballData(String name, int pointsFor, int pointsAgainst) {
        this.name = name;
        this.pointsFor = pointsFor;
        this.pointsAgainst = pointsAgainst;
    }
    public int getSpread(){
        return Math.abs(pointsFor - pointsAgainst);
    }

    @Override
    public String toString() {
        return "FootballStats{" +
                "name='" + name + '\'' +
                ", pointsFor=" + pointsFor +
                ", pointsAgainst=" + pointsAgainst +
                ", spread=" + getSpread() +
                '}';
    }
}
