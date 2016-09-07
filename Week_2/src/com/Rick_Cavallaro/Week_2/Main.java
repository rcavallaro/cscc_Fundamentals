package com.Rick_Cavallaro.Week_2;

/**
 * Created by Rick on 9/6/2016.
 */
public class Main {
    public static void main(String [] Args)
    {
        System.out.println("Week 2");
        String[] days = {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
        int[] temps = {45, 29, 10, 22, 41, 28, 33};
        int[] precip = {95, 60, 25, 5, 0, 75, 90};

        int tempThreshold = 32;
        int precipThreshold = 50;

        for (int i=0; i<days.length; i++)
        {
            if ((temps[i] <= tempThreshold) && (precip[i] > precipThreshold)) {
                System.out.println("It is likely to snow " + days[i]);
            }
        }
    }
}
