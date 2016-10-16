package com.Rick_Cavallaro.Project_2;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by Rick on 10/16/2016.
 */
public class Main {
    private static String userInputMenuOption() {
        System.out.println("Please choose an option:\n" +
                "(1) Add a task.\n" +
                "(2) Remove a task.\n" +
                "(3) Update a task.\n" +
                "(4) List all tasks.\n" +
                "(5) List all tasks of a certain priority.\n" +
                "(0) Exit.\n\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String userInput(String strPrompt) {
        System.out.println(strPrompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

/*
    private static String userInputTaskNumber() {
        System.out.println("Please enter a task number: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
*/

    public static void main(String[] args) {
        String userMenuOption;
        String strPrompt =  "";
        String userTaskDescription;
        String userTaskNumber;
        String[] strTaskName = new String[99];
        String[] strTaskDescription = new String[99];
        String[] strTaskPriority = new String[99];
        int intTaskCount = 0;
        int intTaskNumber = 0;

        strPrompt =  "";
        userMenuOption = userInputMenuOption();
        while (!userMenuOption.equals("0")) {
            switch (userMenuOption) {
                case "1":
                    // Add a task to the end of the list
                    strTaskName[intTaskCount] = userInput("Enter the new task's name: ");
                    strTaskDescription[intTaskCount] = userInput("Enter the new task's description: ");
                    strTaskPriority[intTaskCount] = userInput("Enter the new task's description: ");
                    intTaskCount += 1;
                    break;
                case "2":
                    // Remove the specified task
                    strPrompt =  "Enter the index of a task to remove: ";
                    userTaskNumber = userInput(strPrompt);
                    intTaskNumber = Integer.parseInt(userTaskNumber);
                    while (intTaskNumber >= 0 && intTaskNumber < intTaskCount){
                        System.out.println("Shifting item " + (intTaskNumber + 1));
                        strTaskName[intTaskNumber] = strTaskName[intTaskNumber + 1];
                        strTaskDescription[intTaskNumber] = strTaskDescription[intTaskNumber + 1];
                        strTaskPriority[intTaskNumber] = strTaskPriority[intTaskNumber + 1];
                        intTaskNumber += 1;
                    }
                    intTaskCount -= 1;
                    break;
                case "3":
                    // Update the specified task
                    strPrompt =  "Enter the index of a task to update: ";
                    userTaskNumber = userInputTaskNumber();
                    intTaskNumber = Integer.parseInt(userTaskNumber);
                    if (intTaskNumber >= 0 && intTaskNumber < intTaskCount){
                        strPrompt =  "";
                        userTaskDescription = userInput(strPrompt);
                        strPrompt =  "Enter the new description: ";
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
            strPrompt =  "";
            userMenuOption = userInputMenuOption();
        }
    }
}
