package com.Rick_Cavallaro.Week_06;

/*
 * Created by Rick on 10/4/2016.
 */
import java.util.Scanner;

class UserInput {
    static Scanner scanner = new Scanner(System.in);

    public int promptInt(String prompt) {
        System.out.println(prompt + ":  ");
        String input = scanner.nextLine();

        int intInput = 0;
        boolean isInt = false;

        while (!isInt) {
            try {
                intInput = Integer.parseInt(input);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println(input + " is not a valid integer.");
                input = scanner.nextLine();
            }
        }
        return intInput;
    }

    public double promptDouble(String prompt) {
        System.out.println(prompt + ":  ");
        String input = scanner.nextLine();

        double doubleInput = 0;
        boolean isDouble = false;

        while (!isDouble) {
            try {
                doubleInput = Double.parseDouble(input);
                isDouble = true;
            } catch (NumberFormatException e) {
                System.out.println(input + " is not a valid double.");
                input = scanner.nextLine();
            }
        }
        return doubleInput;
    }

    public String promptString(String prompt) {
        System.out.println(prompt + ":  ");
        return scanner.nextLine();
    }
}

public class Main {
    public static void main(String[] args) {
        UserInput input = new UserInput();
        String aString = input.promptString("Enter a string");
        System.out.println("The string you entered is " + aString);
        int anInt = input.promptInt("Enter an integer");
        System.out.println("The integer you entered is " + anInt);
        double aDouble = input.promptDouble("Enter a double");
        System.out.println("The double you entered is " + aDouble);
    }
}

