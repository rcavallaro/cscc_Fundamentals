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
        String[] strAvgTemps = {"0.0", "0.0", "0.0", "0.0", "0.0"};

        System.out.println("Enter average temps for next 5 days separated by spaces for " + currentCity + ":  ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        strAvgTemps = input.split(",", 5);

        double[] dblAvgTemps = {0.0,0.0,0.0,0.0,0.0};
        int countAvgTemps = strAvgTemps.length;
        for (int i = 0; i < countAvgTemps; i++ ){
            dblAvgTemps[i] = Double.parseDouble(strAvgTemps[i]);
        }
        double dblTotalAvgTemp = 0.0;
        for (double dblAvgTemp : dblAvgTemps){
            dblTotalAvgTemp += dblAvgTemp;
        }
        double dblAvgAvgTemp = 0.0;
        if (countAvgTemps > 0){
            dblAvgAvgTemp = dblTotalAvgTemp / countAvgTemps;
        }
        return input;
    }

    public static void main(String[] args) {
        String userCityName;
        TreeSet<String> cities = new TreeSet<>();

        userCityName = userInputCityName();
        while (!userCityName.toUpperCase().equals("END")) {
            cities.add(userCityName);
            userCityName = userInputCityName();
        }
        for (String city : cities) {
            userInputAvgTemps(city);
        }
    }
}
