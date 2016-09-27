package com.Rick_Cavallaro.Week_04;

/*
 * Created by Rick on 9/26/2016.
 */
import java.util.Map;
import java.util.TreeSet;
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

    private static void userOutput(String city, double dblAvgAvgTemp){
        System.out.println("Five day average for " + city + " is " + dblAvgAvgTemp);
    }

    public static void main(String[] args) {
        String userCityName;
        String userAvgTemps;
        String[] strAvgTemps = {"0.0", "0.0", "0.0", "0.0", "0.0"};
        TreeSet<String> cities = new TreeSet<>();

        userCityName = userInputCityName();
        while (!userCityName.toUpperCase().equals("END")) {
            cities.add(userCityName);
            userCityName = userInputCityName();
        }

        for (String city : cities) {
            userAvgTemps = userInputAvgTemps(city);
            strAvgTemps = userAvgTemps.split(" ", 5);

            double[] dblAvgTemps = {0.0, 0.0, 0.0, 0.0, 0.0};
            int countAvgTemps = strAvgTemps.length;
            for (int i = 0; i < countAvgTemps; i++) {
                dblAvgTemps[i] = Double.parseDouble(strAvgTemps[i]);
            }
            double dblTotalAvgTemp = 0.0;
            for (double dblAvgTemp : dblAvgTemps) {
                dblTotalAvgTemp += dblAvgTemp;
            }
            double dblAvgAvgTemp = 0.0;
            if (countAvgTemps > 0) {
                dblAvgAvgTemp = dblTotalAvgTemp / countAvgTemps;
            }

            userOutput(city, dblAvgAvgTemp);
        }
    }
}
