package com.Rick_Cavallaro.Week_04;

/*
 * Created by Rick on 9/26/2016.
 */
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

import java.util.Scanner;

public class Main {

    private static String userInputCityName() {
        System.out.println("Enter a City name or enter 'END' to finish Cities:  ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //double doubleInput = Double.parseDouble(input);
        return input;
    }

    private static String userInputAvgTemps(String currentCity) {
        System.out.println("Enter average temps for next 5 days separated by spaces for " + currentCity + ":  ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    private static void userOutput(String city, double dblAvgAvgTemp) {
        System.out.println("Five day average for " + city + " is " + dblAvgAvgTemp);
    }

    static Map<String, Double[]> assignTemps(String cityName, Double[] dblTemps) {

        Map<String, Double[]> cityTemps = new TreeMap<>();
        cityTemps.put(cityName, dblTemps);
        return cityTemps;
    }

    public static void main(String[] args) {
        String userCityName;
        String userAvgTemps;
        Double[] dblAvgTemps = {0.0, 0.0, 0.0, 0.0, 0.0};
        String[] strAvgTemps = {"0.0", "0.0", "0.0", "0.0", "0.0"};
        Map<String, Double[]> cities = new TreeMap<>();

        userCityName = userInputCityName();
        while (!userCityName.toUpperCase().equals("END")) {
            dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};
            cities.put(userCityName, dblAvgTemps);
            //cities.assignTemps(userCityName,dblAvgTemps);
            userCityName = userInputCityName();
        }

        Set<String> cityNames = cities.keySet();

        for (String cityName : cityNames) {
            userAvgTemps = userInputAvgTemps(cityName);
            strAvgTemps = userAvgTemps.split(" ", 5);

            dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};
            int countAvgTemps = strAvgTemps.length;
            for (int i = 0; i < countAvgTemps; i++) {
                dblAvgTemps[i] = Double.parseDouble(strAvgTemps[i]);
            }
            cities.put(cityName, dblAvgTemps);
        }

        for (String cityName : cityNames) {
            double dblTotalAvgTemp = 0.0;

            dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};
            dblAvgTemps = cities.get(cityName);
            for (double dblAvgTemp : dblAvgTemps) {
                dblTotalAvgTemp += dblAvgTemp;
            }
            double dblAvgAvgTemp = 0.0;

            dblAvgAvgTemp = dblTotalAvgTemp / 5;

            userOutput(cityName, dblAvgAvgTemp);
        }
    }
}


