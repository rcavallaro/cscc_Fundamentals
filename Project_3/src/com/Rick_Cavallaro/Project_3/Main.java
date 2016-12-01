package com.Rick_Cavallaro.Project_3;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import java.util.Scanner;

class Task implements Comparable<Task> {
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

    @Override
    public int compareTo(Task o) {
        if (!priority.equals(o.priority)) {
            return priority.compareTo(o.priority);
        } else {
            return name.compareTo(o.name);
        }
    }

    public void display() {
        System.out.println(
            ", Number: " + this.number +
            ", Name: " + this.name +
            ", Description: " + this.description +
            ", Priority: " + this.priority);
    }
}

class TaskList implements Iterable<Task>{
    private Map<String, Task> tasksMap = new TreeMap<>();
    //private List<Task> tasks = new ArrayList<Task>();

    //public Iterator<Task> iterator() {
    @Override
    public Iterator<Task> iterator() {
        return tasksMap.values().iterator();
    }

    void put(Task task){
        tasksMap.put(task.number, task);
    }

    void remove(String taskNumber){
        tasksMap.remove(taskNumber);
    }

    Task get(String taskNumber){
        return tasksMap.get(taskNumber);
    }

    //public void sort() {
    //    Collections.sort(tasksMap);
    //}

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
        TaskList tasks = new TaskList();
        Task task = new Task("","","","");
        //Map<String, Task> tasks2 = new TreeMap<>();
        //Tasks tasks = new Tasks();
        Integer intTaskCount = 0;
        int intTaskNumber = 0;
        // Create easy test data
        Task task0 = new Task("0","Fix leak","Fix leaky bathroom fawcet","4");
        task0.display();
        tasks.put(task0);
        Task task1 = new Task("1","Empty trash","Take out to curb","1");
        task1.display();
        tasks.put(task1);
        Task task2 = new Task("2","Read contract","Read employment contract","5");
        task2.display();
        tasks.put(task2);
        Task task3 = new Task("3","Read lease","Read appartment lease","5");
        task3.display();
        tasks.put(task3);
        intTaskCount = 4;

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
                    //tasks2.remove(userTaskNumber);
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
                        tasks.put(task);
                        System.out.println("Task (" + userTaskNumber + ") Updated.");
                    }
                    break;
                case "4":
                    // List all known tasks
                    System.out.println("\nAll Tasks\n");

                    //tasks.sort();

                    for (Task t: tasks) {
                        t.display();
                        //System.out.println(
                        //        ", Number: " + task.number +
                        //       ", Name: " + task.name +
                        //        ", Description: " + task.description +
                        //        ", Priority: " + task.priority);
            }
                    System.out.println("\n");
                    break;
                case "5":
                    // List all known tasks
                    String strListTaskPriority = userInputPriority
                            ("Enter priority of tasks to list: ");
                    System.out.println("\nTasks\n");

                    //tasks.sort();

                    for (Task t: tasks) {
                        if (t.priority.equals(strListTaskPriority)){
                            System.out.println(
                                ", Number: " + t.number +
                                ", Name: " + t.name +
                                ", Description: " + t.description +
                                ", Priority: " + t.priority);
                        }
                    }

                    System.out.println("\n");
                    break;
            }
            userMenuOption = userInputMenuOption();
        }
    }
}
