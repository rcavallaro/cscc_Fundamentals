package com.Rick_Cavallaro.Week_05;

/*
 * Created by Rick on 9/27/2016.
 */

import java.util.ArrayList;
import java.util.List;

class Contact{
    String name;
    String eMail;

    Contact(String name, String eMail){
        this.name = name;
        this.eMail = eMail;
    }
}

class AddressBook{
    List<Contact> contacts = new ArrayList<>();

    void add(Contact contact){
        contacts.add(contact);
    }

    String searchByName(String name){
        for (Contact entry: contacts){
            if (entry.name.equals(name)){
                return entry.eMail;
            }
        }
        return null;
    }
}
class WeatherData {
    // class fields
    final static String TEMP_UNIT = "F";
    final static String HUMIDITY_UNIT = "%";
    final static String PRECIPITATION_UNIT = "%";
    final static int FREEZING_TEMP = 32;

    String cityName;
    double temperature;
    double humidity;
    double precipitation;

    WeatherData(String cityName, double temperature, double humidity,
                double precipitation) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
    }


    private static double celciusToFahrenheit(double celsiusTemperature) {
        double fahrenheitTemperature = 9.0 / 5 * celsiusTemperature + 32;
        return fahrenheitTemperature;
    }

    private static double fahrenheitToCelciusTo(double fahrenheitTemperature) {
        double celsiusTemperature = (fahrenheitTemperature - 32.0) * 5.0 / 9;
        return celsiusTemperature;

    }
}

public class Main {
/*
            static List<String> combine(List<String> firstList, List<String> secondList) {
                List<String> listNew = new ArrayList<String>();
                for (String thing : firstList) {
                    listNew.add(thing);
                }
                for (String thing : secondList) {
                    listNew.add(thing);
                }
                return listNew;
            }
*/

/*
            static Map<String, Integer> assignTemps(String[] cities, int[] temps) {
                Map<String, Integer> temperatures = new HashMap<>();

                for (int i = 0; i < cities.length; i++) {
                    temperatures.put(cities[i], temps[i]);
                }
                return temperatures;
            }
*/

/*
            static void displayFreezing(Map<String, Integer> temps) {
                for (String city : temps.keySet()) {
                    if (temps.get(city) <= 32) {
                        System.out.println("It's cold in " + city + "!");
                    }
                }
            }
*/

    public static void main(String[] args) {
        AddressBook myAddressBook = new AddressBook();
        Contact rick = new Contact("Rick", "Rick@GMail.com");
        Contact bob = new Contact("Bob", "Bob@GMail.com");
        Contact sue = new Contact("Sue", "Sue@GMail.com");

        myAddressBook.add(rick);
        myAddressBook.add(bob);
        myAddressBook.add(sue);

/*
        WeatherData columbus = new WeatherData("Columbus", 70, 65, 10);

        System.out.println("City name: " + columbus.cityName);
        System.out.println("Temperature: " + columbus.temperature + WeatherData.TEMP_UNIT);
        System.out.println("Humidity: " + columbus.humidity + WeatherData.HUMIDITY_UNIT);
        System.out.println("Chance of precipition: " + columbus.precipitation + WeatherData.PRECIPITATION_UNIT);
*/
          /*  String[] cities = {"Cleveland", "New York", "Dallas", "Tampa"};
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
            }*/
    }
}

