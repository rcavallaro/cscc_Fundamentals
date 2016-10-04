package com.Rick_Cavallaro.Play;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
/*
 * Created by Rick on 10/4/2016.
 */
public class Play {
    public static void main(String[] args) {
        String userCityName;
        String userAvgTemps;
        Double[] dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        Double[] dblOldTemps = {9.9, 8.8, 7.7, 6.6, 5.5};
        Map<String, Double[]> cities = new TreeMap<>();

        // Just create some empty entries
        cities.put("Columbus", dblAvgTemps);
        dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        cities.put("Dayton", dblAvgTemps);
        dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        cities.put("Akron", dblAvgTemps);
        dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};

        userCityName = "Dayton";
        dblAvgTemps[0] = 3.0;
        dblAvgTemps[1] = 3.1;
        dblAvgTemps[2] = 3.2;
        dblAvgTemps[3] = 3.3;
        dblAvgTemps[4] = 3.4;
        cities.put(userCityName, dblAvgTemps);
        dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        userCityName = "Akron";
        dblAvgTemps[0] = 1.0;
        dblAvgTemps[1] = 1.1;
        dblAvgTemps[2] = 1.2;
        dblAvgTemps[3] = 1.3;
        dblAvgTemps[4] = 1.4;
        cities.put(userCityName, dblAvgTemps);
        dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        userCityName = "Columbus";
        dblAvgTemps[0] = 2.0;
        dblAvgTemps[1] = 2.1;
        dblAvgTemps[2] = 2.2;
        dblAvgTemps[3] = 2.3;
        dblAvgTemps[4] = 2.4;
        cities.put(userCityName, dblAvgTemps);
        dblAvgTemps = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        userCityName = "Akron";
        dblAvgTemps = cities.get(userCityName);
        System.out.println("Values for " + userCityName + ": " + dblAvgTemps[0]);
        System.out.println("Values for " + userCityName + ": " + dblAvgTemps[1]);
        System.out.println("Values for " + userCityName + ": " + dblAvgTemps[2]);
        System.out.println("Values for " + userCityName + ": " + dblAvgTemps[3]);
        System.out.println("Values for " + userCityName + ": " + dblAvgTemps[4]);

    }
}
