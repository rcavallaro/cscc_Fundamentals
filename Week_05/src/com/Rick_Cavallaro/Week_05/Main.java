package com.Rick_Cavallaro.Week_05;

/*
 * Created by Rick on 9/27/2016.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
    public class Main {
        static List<String> combine(List<String> firstList, List<String> secondList) {
            List<String> listNew = new ArrayList<String>();
            for (String thing: firstList){
                listNew.add(thing);
            }
            for (String thing: secondList){
                listNew.add(thing);
            }
            return listNew;
        }
        static Map<String, Integer> assignTemps(String[] cities, int[] temps) {
            Map<String, Integer> temperatures = new HashMap<>();

            for (int i = 0; i < cities.length; i++) {
                temperatures.put(cities[i], temps[i]);
            }
        return temperatures;
        }

        static void displayFreezing(Map<String, Integer> temps){
            for (String city: temps.keySet()) {
                if (temps.get(city) <= 32) {
                    System.out.println("It's cold in " + city + "!");
                }
            }
        }

        public static void main(String[] args) {
            String[] cities = {"Cleveland", "New York", "Dallas", "Tampa"};
            int[] temps = {15, 30, 45, 70};
            Map tempMap = assignTemps(cities, temps);
            displayFreezing(tempMap);
            List<String> listA = new ArrayList<String>();
            listA.add("One");
            listA.add("Two");
            listA.add("Three");
            List<String> listB = new ArrayList<String>();
            listB.add("Four");
            listB.add("Five");
            listB.add("Six");
            listB.add("Seven");
            List<String> listC = combine(listA, listB);

            for (String thing: listC){
                System.out.println(thing);
            }
        }
    }

