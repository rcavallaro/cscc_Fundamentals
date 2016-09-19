package com.Rick_Cavallaro.Project_1;

import com.sun.org.apache.xpath.internal.SourceTree;

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
                "(0) Exit.\n\n");
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

    public static void main(String[] args) {
        String userMenuOption;
        String userTaskDescription;
        String userTaskNumber;
        String[] strTask = new String[99];
        int intTaskCount = 0;
        int intTaskNumber = 0;

        userMenuOption = userInputMenuOption();
        while (!userMenuOption.equals("0")) {
            switch (userMenuOption) {
                case "1":
                    // Add a task to the end of the list
                    userTaskDescription = userInputTaskDescription();
                    strTask[intTaskCount] = userTaskDescription;
                    intTaskCount += 1;
                    break;
                case "2":
                    // Remove the specified task
                    userTaskNumber = userInputTaskNumber();
                    intTaskNumber = Integer.parseInt(userTaskNumber);
                    while (intTaskNumber >= 0 && intTaskNumber < intTaskCount){
                        System.out.println("Shifting item " + (intTaskNumber + 1));
                        strTask[intTaskNumber] = strTask[intTaskNumber + 1];
                        intTaskCount -= 1;
                        intTaskNumber += 1;
                    }
                    break;
                case "3":
                    // Update the specified task
                    userTaskNumber = userInputTaskNumber();
                    intTaskNumber = Integer.parseInt(userTaskNumber);
                    if (intTaskNumber >= 0 && intTaskNumber < intTaskCount){
                        userTaskDescription = userInputTaskDescription();
                        strTask[intTaskNumber] = userTaskDescription;
                        System.out.println("Task (" + userTaskNumber + ") Updated.");
                    }
                    break;
                case "4":
                    // List all known tasks
                    System.out.println("\nTasks\n");
                    for (int i = 0; i < intTaskCount; i++){
                        System.out.println("(" + i + ") " + strTask[i]);
                    }
                    System.out.println("\n");
                    break;
            }
            userMenuOption = userInputMenuOption();
        }
    }
}