package com.Rick_Cavallaro.Project_1;

import java.util.Scanner;

/*
 * Created by Rick on 9/17/2016.
 */
public class Main {

    private static String userInputMenuOption() {
        System.out.println("Please choose an option:\n" +
                "(1) Add a task.\n" +
                "(2) Remove a task.\n" +
                "(3) Update a task.\n" +
                "(4) List all tasks.\n" +
                "(0) Exit.\n" +
                "\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String userInputTaskDescription() {
        System.out.println("Please enter a task description: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String userInputTaskNumber() {
        System.out.println("Please enter a task number: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void userOutput(double celciousTemperature) {
        System.out.println("Celcious temperature is " + celciousTemperature);
    }

    public static void main(String[] args) {
        String userMenuOption;

        userMenuOption = userInputMenuOption();
        while (userMenuOption <> "0") {
            userMenuOption = userInputMenuOption();
        }

    }
}