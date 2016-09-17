package com.Rick_Cavallaro.Week_03;

//import java.util.DoubleSummaryStatistics;
import java.util.Scanner;
/*
 * Created by Rick on 9/13/2016.
*/
public class Main {

    private static double celciusToFahrenheit(double celsiusTemperature) {
        double fahrenheitTemperature = 9.0 / 5 * celsiusTemperature + 32;
        return fahrenheitTemperature;
    }

    private static double fahrenheitToCelciusTo(double fahrenheitTemperature) {
        double celsiusTemperature = (fahrenheitTemperature - 32.0) * 5.0 / 9;
        return celsiusTemperature;
    }

    private static double userInput(){
        System.out.println("Enter a Fahrenheit temperature.");
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        double doubleInput = Double.parseDouble(input);
        return doubleInput;
    }

    private static void userOutput(double celciousTemperature){
        System.out.println("Celcious temperature is " + celciousTemperature);
    }

    public static void main(String[] args) {
        double userTemperature;

        userTemperature = userInput();
        while (userTemperature >= -460) {
            double celciusTemperature = fahrenheitToCelciusTo(userTemperature);
            userOutput(celciusTemperature);
            userTemperature = userInput();
        }
    }
}
