package com.Rick_Cavallaro.Project_3;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Map;
import java.util.TreeMap;
//import java.util.TreeSet;

import java.util.Scanner;

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

class Tasks{
    //TreeSet<Task> tasks = new TreeSet<>();
    Map<String, Task> tasksMap = new TreeMap<>();
    //TreeSet <Integer>treeadd = new TreeSet<Integer>();

    void put(Task task){
        tasksMap.put(task.number, task);
    }

    void remove(String taskNumber){
        tasksMap.remove(taskNumber);
    }

    Task get(String taskNumber){
        return tasksMap.get(taskNumber);
    }
}

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
        while (priority.length()==0 || (priority.length()==1 && !strValidPriorities.contains(priority))) {
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
        Tasks tasks = new Tasks();
        Task task = new Task("","","","");
        Map<String, Task> tasks2 = new TreeMap<>();
        //Tasks tasks = new Tasks();
        Integer intTaskCount = 0;
        int intTaskNumber = 0;

        userMenuOption = userInputMenuOption();
        while (!userMenuOption.equals("0")) {
            switch (userMenuOption) {
                case "1":
                    // Add a task to the end of the list
                    task = new Task("","","","");
                    task.name = userInput("Enter the new task's name: ");
                    task.description = userInput("Enter the new task's description: ");
                    task.priority = userInputPriority("Enter the new task's priority: ");
                    //tasks.add(task);
                    task.number = intTaskCount.toString();
                    //tasks2.put(task.number, task);
                    tasks.put(task);
                    intTaskCount += 1;
                    break;
                case "2":
                    // Remove the specified task
                    userTaskNumber = userInput("Enter the index of a task to remove: ");
                    tasks2.remove(userTaskNumber);
                    tasks.remove(userTaskNumber);
                    break;
                case "3":
                    // Update the specified task
                    userTaskNumber = userInput("Enter the index of a task to update: ");
                    task = tasks.get(userTaskNumber);
                    if (task == null) {
                        System.out.println("Task number " + userTaskNumber + " was not found");
                    }
                    else{
                        //task.number = userTaskNumber; // Not needed since we can't change this
                        task.name = userInput("Enter the task's new name: ");
                        task.description = userInput("Enter the task's new description: ");
                        task.priority = userInputPriority("Enter the new task's new priority: ");
                        tasks.put(usertask);
                        System.out.println("Task (" + userTaskNumber + ") Updated.");
                    }
                    break;
                case "4":
                    // List all known tasks
                    System.out.println("\nAll Tasks\n");
                     for (task: tasks) {
                        System.out.println(
                                ", Number: " + task.number +
                                ", Name: " + task.name +
                                ", Description: " + task.description +
                                ", Priority: " + task.priority);
            }
                    System.out.println("\n");
                    break;
                case "5":
                    // List all known tasks
                    String strListTaskPriority = userInputPriority
                            ("Enter priority of tasks to list: ");
                    System.out.println("\nTasks\n");
                    for (task: tasks) {
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
