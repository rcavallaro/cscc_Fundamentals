package com.Rick_Cavallaro.Week_1;

public class Main {

    /**
     * Created by Rick on 8/30/2016.
     **/
    public static void main(String[] args)
    {
        String cityName = "Columbus";
        int zipCode = 43215;
        float[] temperatures = {32, 25, 27, 40, 45};
        float averageTemp = (temperatures[0] + temperatures[1] + temperatures[2]
                + temperatures[3] + temperatures[4]);
        System.out.println("City: "+cityName);
        System.out.println("Zip Code: "+zipCode);
        System.out.println("Average temperature: "+averageTemp);
    }
}

