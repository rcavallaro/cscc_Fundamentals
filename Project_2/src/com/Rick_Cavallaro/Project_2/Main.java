package com.Rick_Cavallaro.Project_2;

import java.util.Map;
import java.util.TreeMap;
//import java.util.TreeSet;

import java.util.Scanner;

/*
 * Created by Rick on 10/16/2016.
 */

class Task{
    String number;
    String name;
    String description;
    String priority;

    Task(String number, String name, String description, String priority){
        this.number =  number;
        this.name = name;
        this.description = description;
        this.priority = priority;
    }
}

/*
// This was an idea for a future project not fully developed
class Tasks{
    //TreeSet<Task> tasks = new TreeSet<>();
    Map<String, Task> tasks = new TreeMap<>();
    //TreeSet <Integer>treeadd = new TreeSet<Integer>();

    void add(Task task){
        tasks.put(task.number, task);
    }

    void remove(Task task){
        tasks.remove(task.number);
    }

    Task searchByNumber(String taskNumber){
        return tasks.get(taskNumber);
    }
}
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

    private static String userInputPriority(String strPrompt) {
        String strValidPriorities = "012345";
        System.out.println(strPrompt);
        Scanner scanner = new Scanner(System.in);
        String priority;
        priority = scanner.nextLine();
        while (priority.length()==0 ||
               priority.length() > 1 ||
              (priority.length()==1 && !strValidPriorities.contains(priority))) {
            System.out.println("Priority must be 0 to 5");
            System.out.println(strPrompt);
            priority = scanner.nextLine();
        }
        return priority;
    }

    public static void main(String[] args) {
        String userMenuOption;
        String strPrompt =  "";
        String userTaskDescription;
        String userTaskNumber;
        Map<String, Task> tasks2 = new TreeMap<>();
        //Tasks tasks = new Tasks();
        Integer intTaskCount = 0;
        int intTaskNumber = 0;

        userMenuOption = userInputMenuOption();
        while (!userMenuOption.equals("0")) {
            switch (userMenuOption) {
                case "1":
                    // Add a task to the end of the list
                    Task task = new Task("","","","");
                    task.name = userInput("Enter the new task's name: ");
                    task.description = userInput("Enter the new task's description: ");
                    task.priority = userInputPriority("Enter the new task's priority: ");
                    //tasks.add(task);
                    task.number = intTaskCount.toString();
                    tasks2.put(task.number, task);
                    intTaskCount += 1;
                    break;
                case "2":
                    // Remove the specified task
                    userTaskNumber = userInput("Enter the index of a task to remove: ");
                    tasks2.remove(userTaskNumber);
                    break;
                case "3":
                    // Update the specified task
                    userTaskNumber = userInput("Enter the index of a task to update: ");
                    task = tasks2.get(userTaskNumber);
                    if (task == null) {
                        System.out.println("Task number " + userTaskNumber + " was not found");
                    }
                    else{
                        task.name = userInput("Enter the task's new name: ");
                        task.description = userInput("Enter the task's new description: ");
                        task.priority = userInputPriority("Enter the new task's new priority: ");
                        System.out.println("Task (" + userTaskNumber + ") Updated.");
                    }
                    break;
                case "4":
                    // List all known tasks
                    System.out.println("\nAll Tasks\n");
                    //task = new Task("","","","");
                    for(Map.Entry<String,Task> entry : tasks2.entrySet()) {
                        String key = entry.getKey();
                        task = entry.getValue();
                        System.out.println(
                                ", Number: " + task.number +
                                ", Name: " + task.name +
                                ", Description: " + task.description +
                                ", Priority: " + task.priority);
                    }
                    System.out.println("\n");
                    break;
                case "5":
                    // List tasks withthe specified priority
                    String strListTaskPriority = userInputPriority
                            ("Enter priority of tasks to list: ");
                    System.out.println("\nTasks\n");
                    for(Map.Entry<String,Task> entry : tasks2.entrySet()) {
                        String key = entry.getKey();
                        task = entry.getValue();
                        if (task.priority.equals(strListTaskPriority)){
                            System.out.println(
                                    ", Number: " + task.number +
                                    ", Name: " + task.name +
                                    ", Description: " + task.description +
                                    ", Priority: " + task.priority);
                        }
                    }

                    System.out.println("\n");
                    break;
            }
            userMenuOption = userInputMenuOption();
        }
    }
}
