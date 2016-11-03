package com.Rick_Cavallaro.Week_08;

class WeatherData {
    String cityName;
    int[] temperatures;

    WeatherData(String cityName, int[] temperatures) {
        this.cityName = cityName;
        this.temperatures = temperatures;
    }

    public void displayAverageTemp() {
        int numberOfDays = temperatures.length;

        int sum = 0;
        for (int temp: temperatures) {
            sum += temp;
        }

        try {
            int average = sum / numberOfDays;
        }
        catch(NumberFormatException e)
        {
            System.out.println("Not enough information for " + cityName + ".");
        }
        finally {
            System.out.println("The average temperature in " + cityName + " will be: " + average+ ".");
        }

    }


public class Main {
    public void main(String[] args) {
        int[] columbusTemps = {60, 70, 65};
        int[] clevelendTemps = {};

        WeatherData columbus = new WeatherData("Columbus", columbusTemps);
        columbus.displayAverageTemp();

        WeatherData cleveland = new WeatherData("Cleveland", clevelendTemps);
        cleveland.displayAverageTemp();
    }
}

